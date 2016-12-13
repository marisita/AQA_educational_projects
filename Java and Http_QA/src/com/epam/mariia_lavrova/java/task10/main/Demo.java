package com.epam.mariia_lavrova.java.task10.main;

import com.epam.mariia_lavrova.java.task10.parser.excel.ExcelLogic;
import com.epam.mariia_lavrova.java.task10.parser.json.JSONLogic;
import com.epam.mariia_lavrova.java.task10.parser.xml.XMLLogic;
import com.epam.mariia_lavrova.java.task10.post.BookTicket;

public class Demo {
    public static void main(String[] args) {

        XMLLogic xmlLogic = new XMLLogic();
        xmlLogic.writeTicketsFromUrlToXML();

        JSONLogic jsonLogic = new JSONLogic();
        jsonLogic.writePremiumTicketsFromXMLToJSON();

        ExcelLogic excelLogic = new ExcelLogic();
        excelLogic.writePremiumTicketsFromJsonToXls();

        BookTicket bookTicket = new BookTicket();
        bookTicket.bookTicketByID("1");
    }
}
