/**
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task7.calculator;

import com.epam.mariia_lavrova.java.task7.calculator.operations.IOperation;
import com.epam.mariia_lavrova.java.task7.calculator.operations.factory.impl.OperationFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.Scanner;

public class Calculator {

    private static final Logger LOGGER = LogManager.getLogger(Calculator.class);
    private static final String TASK = "\n// 3. Написать калькулятор – программа, которая на входе получает два целых числа (число А и число В), \n" +
            "выполняет арифметическую операцию («+» - сложение, «-» - вычитание, «*» - умножение, «/» - деление) и выводит результат в консоль. \n" +
            "Для каждой операции использовать отдельный метод.\n";
    private static final String VARIABLE_IS_SET = "{} is set = {}";
    private static final String PROGRAM_IN_STRUCTURE = "The program is in the structure {}";
    private static final String INPUT_EXPRESSION = "Please input math expression like 1+5";
    private static final String INCORRECT_NUMBER = "You input wrong number!";
    private static final String INCORRECT_OPERATION = "You input wrong number!";
    private static final String RESULT = "Calculating results: ";
    private static final String CONTINUE = "Do you want to continue? y/n";

    private void printTask() {
        LOGGER.info(TASK);
    }

    private int[] setMathExpression(String mathExpression) {

        int[] mathElements = new int[3];
        int signIndex = -1;
        mathExpression = mathExpression.replaceAll(" ", "");

        for (int i = 1; i < mathExpression.length(); i++) {

            if (mathExpression.charAt(i) == '+') {
                signIndex = i;
                mathElements[0] = 0;
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'if' with condition: (mathExpression.charAt(i) == '+')");
                break;
            }
            if (mathExpression.charAt(i) == '-') {
                signIndex = i;
                mathElements[0] = 1;
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'if' with condition: (mathExpression.charAt(i) == '-')");
                break;
            }
            if (mathExpression.charAt(i) == '*') {
                signIndex = i;
                mathElements[0] = 2;
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'if' with condition: (mathExpression.charAt(i) == '*')");
                break;
            }
            if (mathExpression.charAt(i) == '/') {
                signIndex = i;
                mathElements[0] = 3;
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'if' with condition: (mathExpression.charAt(i) == '/')");
                break;
            }
        }

        if (signIndex == -1) {
            LOGGER.error(INCORRECT_OPERATION);
            LOGGER.trace(PROGRAM_IN_STRUCTURE, "'if' with condition (signIndex == -1)");
        } else {
            LOGGER.debug(VARIABLE_IS_SET, "masElements[0] (code of operation)", mathElements[0]);
            LOGGER.trace(PROGRAM_IN_STRUCTURE, "'if' with condition (signIndex == -1 )to the block else");
            try {
                mathElements[1] = (int) Double.parseDouble(mathExpression.substring(0, signIndex));
                LOGGER.debug(VARIABLE_IS_SET, "masElements[1] (first argument)", mathElements[1]);
                mathElements[2] = (int) Double.parseDouble(mathExpression.substring(signIndex + 1, mathExpression.length()));
                LOGGER.debug(VARIABLE_IS_SET, "masElements[2] (second argument)", mathElements[2]);
            } catch (NumberFormatException e) {
                LOGGER.error(INCORRECT_NUMBER);
            }
        }

        return mathElements;
    }

    private void printResult(double result) {
        LOGGER.info(RESULT + result);
    }

    public void runCalculator() {

        printTask();
        Scanner scanner = new Scanner(System.in);

        do {
            LOGGER.info(INPUT_EXPRESSION);
            String mathExpression = scanner.nextLine();
            LOGGER.debug(VARIABLE_IS_SET, "mathExpression", mathExpression);
            double operationResult = calculate(mathExpression);
            LOGGER.debug(VARIABLE_IS_SET, "operation result", operationResult);
            printResult(operationResult);
            LOGGER.info(CONTINUE);
        } while (!scanner.nextLine().equals("n"));

        scanner.close();
    }

    public double calculate(String mathExpression) {

        int[] mathElements = setMathExpression(mathExpression);
        OperationFactory factory = new OperationFactory();
        IOperation operation = factory.getOperation(mathElements[0]);

        try {
            return operation.execute(mathElements[1], mathElements[2]);
        } catch (IllegalArgumentException e) {
            LOGGER.warn(e.getMessage());
            return 0;
        }
    }

    public static void setLogLevel() {

        LOGGER.info("Please, input log level:");
        LOGGER.info("0 - ALL");
        LOGGER.info("1 - TRACE");
        LOGGER.info("2 - DEBUG");
        LOGGER.info("3 - INFO");
        LOGGER.info("4 - WARN");
        LOGGER.info("5 - ERROR");
        LOGGER.info("6 - FATAL");

        Scanner scanner1 = new Scanner(System.in);
        String levelsFromConsole = scanner1.nextLine();

        LOGGER.debug(VARIABLE_IS_SET, "levelsFromConsole", levelsFromConsole);

        switch (levelsFromConsole) {
            case "0":
                Configurator.setLevel(LOGGER.getName(), Level.ALL);
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'switch' in case " + levelsFromConsole);
                break;
            case "1":
                Configurator.setLevel(LOGGER.getName(), Level.TRACE);
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'switch' in case " + levelsFromConsole);
                break;
            case "2":
                Configurator.setLevel(LOGGER.getName(), Level.DEBUG);
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'switch' in case " + levelsFromConsole);
                break;
            case "3":
                Configurator.setLevel(LOGGER.getName(), Level.INFO);
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'switch' in case " + levelsFromConsole);
                break;
            case "4":
                Configurator.setLevel(LOGGER.getName(), Level.WARN);
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'switch' in case " + levelsFromConsole);
                break;
            case "5":
                Configurator.setLevel(LOGGER.getName(), Level.ERROR);
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'switch' in case " + levelsFromConsole);
                break;
            case "6":
                Configurator.setLevel(LOGGER.getName(), Level.FATAL);
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'switch' in case " + levelsFromConsole);
                break;
            default:
                Configurator.setLevel(LOGGER.getName(), Level.ALL);
                LOGGER.trace(PROGRAM_IN_STRUCTURE, "'switch' in case default");
                break;
        }

        LOGGER.info("You select level " + LOGGER.getLevel());

    }


}
