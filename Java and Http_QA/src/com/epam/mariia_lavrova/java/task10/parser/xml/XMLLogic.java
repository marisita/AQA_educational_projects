package com.epam.mariia_lavrova.java.task10.parser.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.mariia_lavrova.java.task10.constant.Constants.*;

public class XMLLogic {

    private static final Logger LOGGER = LogManager.getLogger(XMLLogic.class);

    private void getXMLFromUrl() {

        try {
            URL tickets = new URL(HOME_URL + BOOKING_URL + GET_TICKET_URL);

            BufferedInputStream bufferedInputStream = new BufferedInputStream(tickets.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FOLDER + TICKETS_NOT_TRIMMED_XML);
            byte[] buffer = new byte[1024];
            int count;
            while ((count = bufferedInputStream.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, count);
            }
            fileOutputStream.close();
            bufferedInputStream.close();
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(FILE_NOT_FOUNT_MESSAGE);
        }
    }

    private void trimXML() {

        try {
            String xmlDataNotTrimmed = FileUtils.readFileToString(new File(OUTPUT_FOLDER + TICKETS_NOT_TRIMMED_XML));
            String xmlData = xmlDataNotTrimmed.replaceAll("\\s{2} ", "");
            FileWriter fileWriter = new FileWriter(new File(OUTPUT_FOLDER + TICKETS_XML), false);
            fileWriter.write(xmlData);
            fileWriter.close();
        } catch (IOException e) {
            LOGGER.info(FILE_NOT_FOUNT_MESSAGE);
        }
    }

    public void writeTicketsFromUrlToXML() {
        getXMLFromUrl();
        trimXML();
    }
}
