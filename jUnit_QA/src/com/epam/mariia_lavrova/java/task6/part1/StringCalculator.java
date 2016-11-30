package com.epam.mariia_lavrova.java.task6.part1;

public class StringCalculator {

    public int add(String numbers) {

        int sum = 0;

        if (!numbers.isEmpty()) {

            String[] numbersCharacters = splitString(numbers);
            int[] numbersArray = convertToIntArray(numbersCharacters);
            String exceptionMessage = "";

            for (int i = 0; i < numbersArray.length; i++) {
                if (numbersArray[i] < 0) {
                    exceptionMessage = exceptionMessage.concat(numbersArray[i] + " ");
                } else if (numbersArray[i] < 1000) {
                    sum += Integer.parseInt(numbersCharacters[i]);
                }
            }
            if (exceptionMessage.length() > 0) {
                throw new IllegalArgumentException("Negatives not allowed: " + exceptionMessage);
            }
        }
        return sum;
    }

    private String[] splitString(String numbers) {

        String[] numbersCharacters;

        if (numbers.startsWith("//")) {
            String delimiter;
            if (numbers.substring(2, 3).equals("[") && numbers.indexOf("]") > 3) {
                delimiter = numbers.substring(3, numbers.indexOf("]"));
            } else {
                delimiter = numbers.substring(2, 3);
            }
            numbersCharacters = numbers.substring(numbers.indexOf("\n") + 1).split(delimiter);
        } else {
            String delimiter = ",|\n";
            numbersCharacters = numbers.split(delimiter);
        }

        return numbersCharacters;
    }

    private int[] convertToIntArray(String[] numbersCharacters) {

        int[] numbersArray = new int[numbersCharacters.length];

        for (int i = 0; i < numbersCharacters.length; i++) {
            numbersArray[i] = Integer.parseInt(numbersCharacters[i]);
        }

        return numbersArray;
    }
}
