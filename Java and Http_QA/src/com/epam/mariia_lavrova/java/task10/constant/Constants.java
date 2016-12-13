package com.epam.mariia_lavrova.java.task10.constant;

public final class Constants {

    public static final String GET_URL = "http://10.23.13.164:9999/BookingTicket/getAvailableTicket.xml";
    public static final String POST_URL = "http://10.23.13.164:9999/BookingTicket/bookTicket.json?userId=1";
    public static final String FILE_NOT_FOUNT_MESSAGE = "File not found!";
    public static final String TICKETS_NOT_TRIMMED_XML = "output/ticketsNotTrimmed.xml";
    public static final String TICKETS_XML = "output/tickets.xml";
    public static final String CATEGORY = "PREMIUM ";
    public static final String PREMIUM_TICKETS_JSON = "output/premiumTickets.txt";
    public static final String PREMIUM_TICKETS_XLS = "output/premiumTickets.xls";
    public static final String REQUEST_METHOD = "POST";

    private Constants() {
    }
}
