package com.epam.mariia_lavrova.java.task10.main;

import com.epam.mariia_lavrova.java.task10.parser.excel.ExcelHelper;
import com.epam.mariia_lavrova.java.task10.parser.json.JSONHelper;
import com.epam.mariia_lavrova.java.task10.parser.xml.XMLHelper;
import com.epam.mariia_lavrova.java.task10.post.BookTicket;

public class Demo {
    public static void main(String[] args) {

        XMLHelper xmlHelper = new XMLHelper();
        xmlHelper.write();

        JSONHelper jsonHelper = new JSONHelper();
        jsonHelper.write();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.write();

        BookTicket bookTicket = new BookTicket();
        bookTicket.bookTicketByID("1");
    }
}
