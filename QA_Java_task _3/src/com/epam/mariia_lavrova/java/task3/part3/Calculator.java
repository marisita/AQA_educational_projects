
/**
 * Created by Mariia_Lavrova on 11/23/2016.
 */

package com.epam.mariia_lavrova.java.task3.part3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private final String TASK = "\n \n // 3. Написать калькулятор – программа, которая на входе получает два целых числа (число А и число В), \n" +
            "выполняет арифметическую операцию («+» - сложение, «-» - вычитание, «*» - умножение, «/» - деление) и выводит результат в консоль. \n" +
            "Для каждой операции использовать отдельный метод.\n";
    private final String INPUT_A = "\nPlease input first operand (A)";
    private final String INPUT_B = "\nPlease input second operand (B)";
    private final String WRONG_NUMBER = "\n You input wrong number!";
    private final String WRONG_OPERATION = "\n You try to divide to zero!";
    private final String RESULTS = "\n Calculating results: ";


    private int a;
    private int b;

    private int additionResult;
    private int subtractionResult;
    private int multiplicationResult;
    private int divisionResult;


    private void printTask() {
        System.out.println(TASK);
    }

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

    private void add() {
        additionResult = a + b;
    }

    private void subtract() {
        subtractionResult = a - b;
    }

    private void multiply() {
        multiplicationResult = a * b;
    }

    private void divide() {
        try{
            divisionResult = a / b;
        } catch (ArithmeticException e) {
            System.out.println(WRONG_OPERATION);
            divisionResult = 0;
        }

    }


    public void doCalculation(){
        add();
        subtract();
        multiply();
        divide();
    }

    public void printCalculationResult() {
        System.out.println(RESULTS);
        System.out.println("a + b = " + additionResult);
        System.out.println("a - b = " + subtractionResult);
        System.out.println("a * b = " + multiplicationResult);
        System.out.println("a / b = " + divisionResult);
    }


    public void getCalculation() {

        printTask();

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        setA(sc1);
        setB(sc2);

        sc1.close();
        sc2.close();

        doCalculation();
        printCalculationResult();

    }

}
