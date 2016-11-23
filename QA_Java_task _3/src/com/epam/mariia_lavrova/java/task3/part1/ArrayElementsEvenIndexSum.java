/**
 * Created by Mariia_Lavrova on 11/23/2016.
 */

// В массиве целых чисел определить сумму элементов, состоящих на чётных позициях.

package com.epam.mariia_lavrova.java.task3.part1;

public class ArrayElementsEvenIndexSum {

    private final String TASK = "\n \n // 1. В массиве целых чисел определить сумму элементов, состоящих на чётных позициях.";
    private final String ARRAY = "\n Generated array: ";
    private final String SUM = "\n Sum of array elements with even indexes: ";

    private int[] array = new int[20];
    private int minArray = -10;
    private int maxArray = 10;
    private int ElementsEvenIndexSum;


    private void printTask() {
        System.out.println(TASK);
    }

    private void fillArrayRandom() {

        for (int i = 0; i < array.length; i++) {
            array[i] = minArray + (int) (Math.random() * ((maxArray - minArray) + 1));
        }
    }


    private void printArray() {

        String str = "{";

        for (int i = 0; i < array.length; i++) {

            str += array[i];

            if (i == array.length - 1) {
                break;
            }

            str += ", ";
        }

        str += "}";
        System.out.println(ARRAY.concat(str));
    }

    private void calculateElementsSum() {

        for (int i = 0; i < array.length; i += 2) {
            ElementsEvenIndexSum += array[i];
        }
    }

    private void printElementsEvenIndexSum() {

        System.out.println(SUM + ElementsEvenIndexSum);

    }

    public void getElementsEvenIndexSum() {

        printTask();
        fillArrayRandom();
        printArray();
        calculateElementsSum();
        printElementsEvenIndexSum();
    }
}
