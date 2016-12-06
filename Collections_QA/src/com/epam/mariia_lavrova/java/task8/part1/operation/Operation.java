package com.epam.mariia_lavrova.java.task8.part1.operation;

import java.util.List;
import java.util.Map;

public abstract class Operation {

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<Map.Entry<String, Integer>> sliceWords(List<Map.Entry<String, Integer>> words, int number) {
        return words.subList(0, number);
    }

    public void printWords(List<Map.Entry<String, Integer>> words, String title) {
        String outputString = "";
        for (Map.Entry<String, Integer> word : words) {
            outputString += "\n " + word.getKey() + " -> " + word.getValue();
        }
        System.out.println(title + outputString);
    }

    public abstract void execute();
}
