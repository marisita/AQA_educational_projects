/**
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task4.part2.calculator;

import com.epam.mariia_lavrova.java.task4.part2.operations.Operation;
import com.epam.mariia_lavrova.java.task4.part2.operations.factory.MyOperationFactory;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {

    private static final String TASK = "\n \n // 3. Написать калькулятор – программа, которая на входе получает два целых числа (число А и число В), \n" +
            "выполняет арифметическую операцию («+» - сложение, «-» - вычитание, «*» - умножение, «/» - деление) и выводит результат в консоль. \n" +
            "Для каждой операции использовать отдельный метод.\n";
    private static final String INPUT_A = "\nPlease input first operand (A)";
    private static final String INPUT_B = "\nPlease input second operand (B)";
    private static final String INPUT_OPERATION_CODE = "\nPlease input operation (+ , - , * , /)";
    private static final String WRONG_NUMBER = "\nYou input wrong number!";
    private static final String RESULTS = "\nCalculating results: ";

    private int a;
    private int b;
    private int operationCode;
    private double operationResult;

    private void printTask() {
        System.out.println(TASK);
    }

    private void setA(Scanner scanner) {

        System.out.println(INPUT_A);

        try {
            a = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(WRONG_NUMBER);
        }
    }


    private void setB(Scanner scanner) {

        System.out.println(INPUT_B);

        try {
            b = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(WRONG_NUMBER);
        }
    }


    private void setOperationCode(Scanner scanner) {

        System.out.println(INPUT_OPERATION_CODE);
        String sign = scanner.nextLine();

        switch (sign) {
            case "+": {
                operationCode = 0;
                break;
            }

            case "-": {
                operationCode = 1;
                break;
            }

            case "*": {
                operationCode = 2;
                break;
            }

            case "/": {
                operationCode = 3;
                break;
            }

            default:
                System.err.println("Command is not found.");
                return;
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
        Scanner scanner3 = new Scanner(System.in);

        do {
            setA(scanner);
            setOperationCode(scanner2);
            setB(scanner);

            executeCalculation();
            printResult();
            System.out.println("Do you want continue? y/n");
            if (scanner3.nextLine().equals("n")) {
                break;
            }
        } while (true);
    }
}
