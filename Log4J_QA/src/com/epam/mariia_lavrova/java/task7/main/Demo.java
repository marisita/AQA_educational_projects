package com.epam.mariia_lavrova.java.task7.main;

import com.epam.mariia_lavrova.java.task7.calculator.Calculator;

public class Demo {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Calculator.setLogLevel();
        calculator.runCalculator();
    }
}