/**
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task4.part2.calculator;

import com.epam.mariia_lavrova.java.task4.part2.operations.Operation;
import com.epam.mariia_lavrova.java.task4.part2.operations.factory.MyOperationFactory;

import java.util.Scanner;


public class Calculator {

    private static final String TASK = "\n \n // 3. Написать калькулятор – программа, которая на входе получает два целых числа (число А и число В), \n" +
            "выполняет арифметическую операцию («+» - сложение, «-» - вычитание, «*» - умножение, «/» - деление) и выводит результат в консоль. \n" +
            "Для каждой операции использовать отдельный метод.\n";
    private static final String INPUT_EXPRESSION = "\nPlease input math expression like 1+5";
    private static final String WRONG_NUMBER = "\nYou input wrong number!";
    private static final String RESULTS = "\nCalculating results: ";

    private int a;
    private int b;
    private int operationCode;
    private double operationResult;

    private void printTask() {
        System.out.println(TASK);
    }

    private void setMathExpression(Scanner scanner) {

        System.out.println(INPUT_EXPRESSION);

        int signIndex = 0;
        String mathExpression = scanner.nextLine();
        char[] temp = mathExpression.toCharArray();

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == '+') {
                signIndex = i;
                operationCode = 0;
                break;
            }
            if (temp[i] == '-') {
                signIndex = i;
                operationCode = 1;
                break;
            }
            if (temp[i] == '*') {
                signIndex = i;
                operationCode = 2;
                break;
            }
            if (temp[i] == '/') {
                signIndex = i;
                operationCode = 3;
                break;
            }
        }

        try {
            a = (int) Double.parseDouble(mathExpression.substring(0, signIndex));
            b = (int) Double.parseDouble(mathExpression.substring(signIndex + 1, mathExpression.length()));
        } catch (NumberFormatException e) {
            System.err.println(WRONG_NUMBER);
        }

    }


    private void executeCalculation() {

        MyOperationFactory factory = new MyOperationFactory();
        Operation operation = factory.getOperation(operationCode);
        operationResult = operation.execute(a, b);
    }


    private void printResult() {

        System.out.println(RESULTS);
        System.out.println(operationResult);
    }


    public void calculate() {

        printTask();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        do {
            setMathExpression(scanner);
            executeCalculation();
            printResult();
            System.out.println("Do you want continue? y/n");
            if (scanner2.nextLine().equals("n")) {
                break;
            }
        } while (true);
    }
}
