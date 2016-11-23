package com.epam.mariia_lavrova.java.task3.main;

import com.epam.mariia_lavrova.java.task3.part1.ArrayElementsEvenIndexSum;
import com.epam.mariia_lavrova.java.task3.part2.StringLengthMoreAverage;
import com.epam.mariia_lavrova.java.task3.part3.Calculator;

/**
 * Created by Mariia_Lavrova on 11/23/2016.
 */
public class Demo {

    public static void main(String[] args) {

        ArrayElementsEvenIndexSum arraySum = new ArrayElementsEvenIndexSum();
        arraySum.getElementsEvenIndexSum();

        StringLengthMoreAverage strings = new StringLengthMoreAverage();
        strings.getStringLengthMoreAverage();

        Calculator calculator = new Calculator();
        calculator.getCalculation();

    }

}
