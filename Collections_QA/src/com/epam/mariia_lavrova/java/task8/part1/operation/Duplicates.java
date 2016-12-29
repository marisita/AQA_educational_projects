package com.epam.mariia_lavrova.java.task8.part1.operation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Duplicates extends Operation {

    private static final Logger LOGGER = LogManager.getLogger(Duplicates.class);
    private static final String DUPLICATE_WORDS = "\nDuplicate word in the file: ";

    private List<Map.Entry<String, Integer>> getWordsAndRepeatsFromFile() {

        Map<String, Integer> words = new HashMap<>();
        Map<String, Integer> wordsDuplicates = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(this.getFilePath()))) {

            while (scanner.hasNext()) {
                String word = scanner.useDelimiter("\\s+").next();
                Integer count = words.get(word);
                if (count == null) {
                    count = 0;
                }

                words.put(word, ++count);

                if (count >= 2) {
                    String stringBuilder = new StringBuilder(word).reverse().toString();
                    wordsDuplicates.put(stringBuilder.toUpperCase(), count);

                    if (wordsDuplicates.size() >= 3) {
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        return new LinkedList<>(wordsDuplicates.entrySet());
    }

    private List<Map.Entry<String, Integer>> sortWordsByLength(List<Map.Entry<String, Integer>> duplicateWords) {
        duplicateWords.sort((o1, o2) -> o1.getKey().length() - o2.getKey().length());
        return duplicateWords;
    }

    @Override
    public void printWords(List<Map.Entry<String, Integer>> words, String title) {
        String outputString = "";
        for (Map.Entry<String, Integer> word : words) {
            outputString += "\n " + word.getKey();
        }
        System.out.println(title + outputString);
    }

    @Override
    public void execute() {
        List<Map.Entry<String, Integer>> duplicateWords = getWordsAndRepeatsFromFile();
        if (!duplicateWords.isEmpty()) {
            duplicateWords = sortWordsByLength(duplicateWords);
            printWords(duplicateWords, DUPLICATE_WORDS);
        }
    }
}
