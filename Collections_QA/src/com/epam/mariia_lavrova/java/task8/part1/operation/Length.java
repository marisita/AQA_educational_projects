package com.epam.mariia_lavrova.java.task8.part1.operation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Length extends Operation {

    private static final Logger LOGGER = LogManager.getLogger(Length.class);

    private static final String LONGEST_WORDS = "\nThe longest words in the file: ";
    private static final int SLICED_NUMBER = 3;

    private List<Map.Entry<String, Integer>> getWordsAndLengthFromFile() {

        Map<String, Integer> words = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(this.getFilePath()))) {
            while (scanner.hasNext()) {
                String word = scanner.useDelimiter("\\s+").next();
                words.put(word, word.length());
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        return new LinkedList<>(words.entrySet());
    }

    private List<Map.Entry<String, Integer>> sortWordsByLength(List<Map.Entry<String, Integer>> longestWords) {
        longestWords.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        return longestWords;
    }

    @Override
    public void execute() {
        List<Map.Entry<String, Integer>> longestWords = getWordsAndLengthFromFile();
        if (!longestWords.isEmpty()) {
            longestWords = sortWordsByLength(longestWords);
            longestWords = sliceWords(longestWords, SLICED_NUMBER);
            printWords(longestWords, LONGEST_WORDS);
        }
    }
}
