package com.epam.mariia_lavrova.java.task10.post;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.epam.mariia_lavrova.java.task10.constant.Constants.*;

public class BookTicket {

    private static final Logger LOGGER = LogManager.getLogger(BookTicket.class);

    public void bookTicketByID(String id) {

        String urlParameters = "[" + id + "]";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        try {
            URL url = new URL(HOME_URL + BOOKING_URL + BOOK_TICKET_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod(REQUEST_METHOD);

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(postData);
            }

        } catch (ProtocolException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
