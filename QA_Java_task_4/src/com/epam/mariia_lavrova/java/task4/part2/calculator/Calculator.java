package com.epam.mariia_lavrova.java.task4.part2.calculator;

import com.epam.mariia_lavrova.java.task4.part2.operations.Operation;
import com.epam.mariia_lavrova.java.task4.part2.operations.factory.MyOperationFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Mariia_Lavrova on 11/24/2016.
 */
public class Calculator {

    private static final String TASK = "\n \n // 3. Написать калькулятор – программа, которая на входе получает два целых числа (число А и число В), \n" +
            "выполняет арифметическую операцию («+» - сложение, «-» - вычитание, «*» - умножение, «/» - деление) и выводит результат в консоль. \n" +
            "Для каждой операции использовать отдельный метод.\n";
    private static final String INPUT_A = "\nPlease input first operand (A)";
    private static final String INPUT_B = "\nPlease input second operand (B)";
    private static final String INPUT_OPERATION_CODE = "\nPlease input operation (+ , - , * , /)";
    private static final String WRONG_NUMBER = "\nYou input wrong number!";
    private static final String RESULTS = "\nCalculating results: ";
    private static final String INPUT_TASK = "\nPlease input task: ";



    private int a;
    private int b;
    private int operationCode;
    private double operationResult;
    private String task;


    private void setA(Scanner sc) {

        System.out.println(INPUT_A);

        try {
            a = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(WRONG_NUMBER);
        }
    }

    private void setB(Scanner sc) {

        System.out.println(INPUT_B);

        try {
            b = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(WRONG_NUMBER);
        }
    }

    private void setOperationCode(Scanner sc) {

        System.out.println(INPUT_OPERATION_CODE);
        String s = sc.nextLine();

        switch (s) {
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
                operationCode = -1;
        }
    }

    private void setTask(Scanner sc) {
        System.out.println(INPUT_TASK);
        task = sc.nextLine();
        task = task.replaceAll(" ", "");

        if (task.indexOf('+') >= 0) {
            try {
                a = Integer.parseInt(task.substring(0, task.indexOf('+')));
                b = Integer.parseInt(task.substring(task.indexOf('+') + 1));
                operationCode = 0;
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат строки!");
            }
        }

        if (task.indexOf('-') >= 0) {
            try {
                a = Integer.parseInt(task.substring(0, task.indexOf('-')));
                b = Integer.parseInt(task.substring(task.indexOf('-') + 1));
                operationCode = 1;
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат строки!");
            }
        }

        if (task.indexOf('*') >= 0) {
            try {
                a = Integer.parseInt(task.substring(0, task.indexOf('*')));
                b = Integer.parseInt(task.substring(task.indexOf('*') + 1));
                operationCode = 2;
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат строки!");
            }
        }

        if (task.indexOf('/') >= 0) {
            try {
                a = Integer.parseInt(task.substring(0, task.indexOf('/')));
                b = Integer.parseInt(task.substring(task.indexOf('/') + 1));
                operationCode = 3;
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат строки!");
            }
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


    public void getCalculation() {

        Scanner sc1 = new Scanner(System.in);
        // Scanner sc2 = new Scanner(System.in);

        /*
        setA(sc1);
        setOperationCode(sc2);
        setB(sc1);
        */

        setTask(sc1);
        executeCalculation();
        printResult();
    }
}
