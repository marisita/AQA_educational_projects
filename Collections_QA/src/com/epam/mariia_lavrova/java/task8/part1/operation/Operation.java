package com.epam.mariia_lavrova.java.task8.part1.operation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public abstract class Operation {

    private static final Logger LOGGER = LogManager.getLogger(Operation.class);

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<Map.Entry<String, Integer>> sliceWords(List<Map.Entry<String, Integer>> words, int number) {
        try {
            return words.subList(0, number);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error(e.getMessage());
            return words;
        }
    }

    public void printWords(List<Map.Entry<String, Integer>> words, String title) {

        String outputString = "";
        for (Map.Entry<String, Integer> word : words) {
            outputString = outputString.concat("\n " + word.getKey() + " -> " + word.getValue());
        }

        LOGGER.info(title + outputString);
    }

    public abstract void execute();
}
