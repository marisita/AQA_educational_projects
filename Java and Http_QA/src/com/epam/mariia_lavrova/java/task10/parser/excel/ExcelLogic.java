package com.epam.mariia_lavrova.java.task10.parser.excel;

import com.epam.mariia_lavrova.java.task10.constant.Constants;
import com.epam.mariia_lavrova.java.task10.parser.xml.domain.Ticket;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ExcelLogic {

    private static final Logger LOGGER = LogManager.getLogger(ExcelLogic.class);

    private List<Ticket> premiumTickets;

    private void getPremiumTicketsFromJSON() throws IOException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(Constants.PREMIUM_TICKETS_JSON));
        premiumTickets = gson.fromJson(br, new TypeToken<List<Ticket>>() {
        }.getType());
    }

    private void writePremiumTicketsToXLS() throws IOException {

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Premium");

        setColumnsWidth(sheet);
        setTitles(sheet);
        CellStyle style = createCellStyle(workbook);
        setTitlesStyle(sheet, style);

        for (int i = 0; i < premiumTickets.size(); i++) {

            Ticket ticket = premiumTickets.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(ticket.getTitle());
            row.createCell(1).setCellValue(ticket.getCategory());
            row.createCell(2).setCellValue(ticket.getDate());
            row.createCell(3).setCellValue(ticket.getId());
            row.createCell(4).setCellValue(ticket.getPlace());
        }

        workbook.write(new FileOutputStream(Constants.PREMIUM_TICKETS_XLS));
        workbook.close();
    }

    private void setTitlesStyle(Sheet sheet, CellStyle style) {
        Iterator<Cell> iterator = sheet.getRow(0).cellIterator();
        while (iterator.hasNext()) {
            Cell cell1 = iterator.next();
            cell1.setCellStyle(style);
        }
    }

    private CellStyle createCellStyle(Workbook wb) {
        Font font = wb.createFont();
        font.setColor(new Short("20"));
        font.setItalic(true);
        CellStyle style = wb.createCellStyle();
        style.setFont(font);
        return style;
    }

    private void setTitles(Sheet sheet) {
        Row title = sheet.createRow(0);
        title.createCell(0).setCellValue("Movie title");
        title.createCell(1).setCellValue("Ticket category");
        title.createCell(2).setCellValue("Date");
        title.createCell(3).setCellValue("Ticket ID");
        title.createCell(4).setCellValue("Place");
    }

    private void setColumnsWidth(Sheet sheet) {
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 3000);
        sheet.setColumnWidth(4, 3000);
    }

    public void writePremiumTicketsFromJsonToXls() {
        try {
            getPremiumTicketsFromJSON();
            writePremiumTicketsToXLS();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
