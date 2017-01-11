package com.epam.mariia_lavrova.java.task10.parser.xml;

import com.epam.mariia_lavrova.java.task10.parser.IParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.mariia_lavrova.java.task10.constant.Constants.*;

public class XMLHelper implements IParser{

    private static final Logger LOGGER = LogManager.getLogger(XMLHelper.class);

    private void getXMLFromUrl() {

        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            URL tickets = new URL(HOME_URL + BOOKING_URL + GET_TICKET_URL);

            bufferedInputStream = new BufferedInputStream(tickets.openStream());
            fileOutputStream = new FileOutputStream(OUTPUT_FOLDER + TICKETS_NOT_TRIMMED_XML);
            byte[] buffer = new byte[1024];
            int count;
            while ((count = bufferedInputStream.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, count);
            }

        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(FILE_NOT_FOUNT_MESSAGE);
        } finally {
            try {
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    private void trimXML() {

        FileWriter fileWriter = null;

        try {
            String xmlDataNotTrimmed = FileUtils.readFileToString(new File(OUTPUT_FOLDER + TICKETS_NOT_TRIMMED_XML));
            String xmlData = xmlDataNotTrimmed.replaceAll("\\s{2} ", "");
            fileWriter = new FileWriter(new File(OUTPUT_FOLDER + TICKETS_XML), false);
            fileWriter.write(xmlData);
        } catch (IOException e) {
            LOGGER.info(FILE_NOT_FOUNT_MESSAGE);
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    @Override
    public void write() {
        getXMLFromUrl();
        trimXML();
    }
}
