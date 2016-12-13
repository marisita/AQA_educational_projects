package com.epam.mariia_lavrova.java.task10.parser.json;

import com.epam.mariia_lavrova.java.task10.constant.Constants;
import com.epam.mariia_lavrova.java.task10.parser.xml.domain.Ticket;
import com.epam.mariia_lavrova.java.task10.parser.xml.domain.Tickets;
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

public class JSONLogic {

    private static final Logger LOGGER = LogManager.getLogger(JSONLogic.class);

    private List<Ticket> getTicketsFromXML() {
        Tickets tickets = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Tickets.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            tickets = (Tickets) jaxbUnmarshaller.unmarshal(new File(Constants.TICKETS_XML));
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        }
        return tickets.getTickets();
    }

    private List<Ticket> findPremiumTickets(List<Ticket> tickets) {

        List<Ticket> premiumTickets = new ArrayList<>();
        try {
            for (Ticket ticket : tickets) {
                if (ticket.getCategory().equals(Constants.CATEGORY)) {
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
        File newFile = new File(Constants.PREMIUM_TICKETS_JSON);
        try (FileWriter fileWriter = new FileWriter(newFile, false)) {
            fileWriter.write(gson.toJson(premiumTickets));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void writePremiumTicketsFromXMLToJSON() {

        List<Ticket> tickets = getTicketsFromXML();
        List<Ticket> premiumTickets = findPremiumTickets(tickets);
        writeTicketsToJSON(premiumTickets);
    }
}
