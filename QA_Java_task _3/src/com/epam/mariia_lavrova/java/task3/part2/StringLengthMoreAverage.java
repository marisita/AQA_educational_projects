/**
 * Class for searching strings with length more than average
 *
 * @author Mariia_Lavrova
 * @since 11/23/2016
 */

package com.epam.mariia_lavrova.java.task3.part2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringLengthMoreAverage {

    private static final String TASK = "\n \n // 2. Ввести n строк с консоли. Вывести на консоль те строки, длина которых больше средней, а также длину.";
    private static final String SET_ARRAY_LENGTH = "\n Please input amount of strings:";
    private static final String WRONG_ARRAY_LENGTH = "\n You input wrong number!";
    private static final String STRINGS = "\n Strings with length more than average:";
    private static final String AVERAGE_LENGTH = "\n Average length of strings: ";


    private String[] array;
    private int arrayN;
    private double averageLength;


    private void printTask() {
        System.out.println(TASK);
    }


    private void setArrayLength(Scanner sc) {

        System.out.println(SET_ARRAY_LENGTH);

        try {
            arrayN = sc.nextInt();
            array = new String[arrayN];
        } catch (InputMismatchException e) {
            System.out.println(WRONG_ARRAY_LENGTH);
        }

    }


    private void setArrayStrings(Scanner sc) {

        System.out.println("\nPlease input " + arrayN + " strings. \n");

        for (int i = 0; i < array.length; i++) {
            System.out.println("Input your string #" + (i + 1));
            array[i] = sc.nextLine();
        }
    }

    private void printArray() {

        System.out.println("\n");

        for (int i = 0; i < array.length; i++) {
            System.out.println("string #" + (i + 1) + ": " + array[i]);
        }

    }


    private void calculateAverageLength() {

        for (int i = 0; i < array.length; i++) {
            averageLength += array[i].length();
        }

        averageLength /= array.length;
    }


    private void printAverageLength() {

        System.out.println(AVERAGE_LENGTH + averageLength);

    }

    private void printStringLengthMoreAverage() {

        System.out.println(STRINGS);

        for (int i = 0; i < array.length; i++) {
            if (array[i].length() >= averageLength) {
                System.out.println("string #" + (i + 1) + ": " + array[i]);
            }
        }

    }


    public void getStringLengthMoreAverage() {

        printTask();

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        setArrayLength(sc1);
        setArrayStrings(sc2);

        //printArray();

        calculateAverageLength();
        printAverageLength();
        printStringLengthMoreAverage();

    }
}
