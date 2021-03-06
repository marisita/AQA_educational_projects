package com.epam.mariia_lavrova.java.task8.part1.operation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Frequency extends Operation {

    private static final Logger LOGGER = LogManager.getLogger(Operation.class);

    private static final String MOST_COMMON_WORDS = "\nThe most common words in the file: ";
    private static final int SLICED_NUMBER = 2;

    private List<Map.Entry<String, Integer>> getWordsAndRepeatsFromFile() {

        Map<String, Integer> words = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(getFilePath()))) {
            while (scanner.hasNext()) {
                String word = scanner.useDelimiter("\\s+").next();
                Integer count = words.get(word);
                if (count == null) {
                    words.put(word, 1);
                } else {
                    words.put(word, count + 1);
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        return new LinkedList<>(words.entrySet());
    }

    private List<Map.Entry<String, Integer>> sortWordsByRepeatNumber(List<Map.Entry<String, Integer>> commonWords) {
        commonWords.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        return commonWords;
    }

    private List<Map.Entry<String, Integer>> sortWordsDescending(List<Map.Entry<String, Integer>> commonWords) {
        commonWords.sort((o1, o2) -> (o2.getKey()).compareTo(o1.getKey()));
        return commonWords;
    }

    @Override
    public void execute() {
        List<Map.Entry<String, Integer>> commonWords = getWordsAndRepeatsFromFile();
        if (!commonWords.isEmpty()) {
            commonWords = sortWordsByRepeatNumber(commonWords);
            commonWords = sliceWords(commonWords, SLICED_NUMBER);
            commonWords = sortWordsDescending(commonWords);
            printWords(commonWords, MOST_COMMON_WORDS);
        }
    }
}
