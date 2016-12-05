/**
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task6.part2.calculator;

import com.epam.mariia_lavrova.java.task6.part2.operations.Operation;
import com.epam.mariia_lavrova.java.task6.part2.operations.factory.MyOperationFactory;

import java.util.Scanner;


public class Calculator {

    private static final String TASK = "\n \n // 3. Написать калькулятор – программа, которая на входе получает два целых числа (число А и число В), \n" +
            "выполняет арифметическую операцию («+» - сложение, «-» - вычитание, «*» - умножение, «/» - деление) и выводит результат в консоль. \n" +
            "Для каждой операции использовать отдельный метод.\n";
    private static final String INPUT_EXPRESSION = "\nPlease input math expression like 1+5";
    private static final String WRONG_NUMBER = "\nYou input wrong number!";
    private static final String RESULTS = "\nCalculating results: ";
    private static final String CONTINUE = "\nDo you want continue? y/n";

    private void printTask() {
        System.out.println(TASK);
    }

    private int[] setMathExpression(String mathExpression) {

        int[] mathElements = new int[3];
        int signIndex = 0;
        mathExpression = mathExpression.replaceAll(" ", "");

        for (int i = 1; i < mathExpression.length(); i++) {

            if (mathExpression.charAt(i) == '+') {
                signIndex = i;
                mathElements[0] = 0;
                break;
            }
            if (mathExpression.charAt(i) == '-') {
                signIndex = i;
                mathElements[0] = 1;
                break;
            }
            if (mathExpression.charAt(i) == '*') {
                signIndex = i;
                mathElements[0] = 2;
                break;
            }
            if (mathExpression.charAt(i) == '/') {
                signIndex = i;
                mathElements[0] = 3;
                break;
            }
        }

        try {
            mathElements[1] = (int) Double.parseDouble(mathExpression.substring(0, signIndex));
            mathElements[2] = (int) Double.parseDouble(mathExpression.substring(signIndex + 1, mathExpression.length()));
        } catch (NumberFormatException e) {
            System.err.println(WRONG_NUMBER);
        }

        return mathElements;
    }

    private void printResult(double result) {

        System.out.println(RESULTS);
        System.out.println(result);
    }

    public void runCalculator() {

        printTask();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(INPUT_EXPRESSION);
            String mathExpression = scanner.nextLine();
            double operationResult = calculate(mathExpression);
            printResult(operationResult);
            System.out.println(CONTINUE);
        } while (!scanner.nextLine().equals("n"));

        scanner.close();
    }

    public double calculate(String mathExpression) {

        int[] mathElements = setMathExpression(mathExpression);
        MyOperationFactory factory = new MyOperationFactory();
        Operation operation = factory.getOperation(mathElements[0]);

        try {
            return operation.execute(mathElements[1], mathElements[2]);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
