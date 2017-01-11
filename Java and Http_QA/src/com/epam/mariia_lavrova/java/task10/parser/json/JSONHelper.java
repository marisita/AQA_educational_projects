package com.epam.mariia_lavrova.java.task10.parser.json;

import com.epam.mariia_lavrova.java.task10.parser.IParser;
import com.epam.mariia_lavrova.java.task10.parser.domain.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.mariia_lavrova.java.task10.constant.Constants.*;

public class JSONHelper implements IParser{

    private static final Logger LOGGER = LogManager.getLogger(JSONHelper.class);

    private List<Ticket> getTicketsFromXML() {

        Tickets tickets = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Tickets.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            tickets = (Tickets) jaxbUnmarshaller.unmarshal(new File(OUTPUT_FOLDER + TICKETS_XML));
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        }
        return tickets.getTickets();
    }

    private List<Ticket> findPremiumTickets(List<Ticket> tickets) {

        List<Ticket> premiumTickets = new ArrayList<>();
        if (!tickets.isEmpty()) {
            for (Ticket ticket : tickets) {
                if (ticket.getCategory().equals(CATEGORY)) {
                    premiumTickets.add(ticket);
                }
            }
        } else {
            LOGGER.info("There is no premium tickets");
        }
        try {
            for (Ticket ticket : tickets) {
                if (ticket.getCategory().equals(CATEGORY)) {
                    premiumTickets.add(ticket);
                }
            }
        } catch (NullPointerException e) {
            LOGGER.error(e.getMessage());
        }

        return premiumTickets;
    }

    private void writeTicketsToJSON(List<Ticket> premiumTickets) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        File newFile = new File(OUTPUT_FOLDER + PREMIUM_TICKETS_JSON);

        try (FileWriter fileWriter = new FileWriter(newFile, false)) {
            fileWriter.write(gson.toJson(premiumTickets));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void write() {
        List<Ticket> tickets = getTicketsFromXML();
        List<Ticket> premiumTickets = findPremiumTickets(tickets);
        writeTicketsToJSON(premiumTickets);
    }
}
