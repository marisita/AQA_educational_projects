/**
 * Class for interaction with a user and searching prime numbers
 *
 * @author Mariia_Lavrova
 * @since 12/8/2016
 */

package com.epam.mariia_lavrova.java.task9.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class UserUtil {

    private static final Logger LOGGER = LogManager.getLogger(UserUtil.class);

    private static final String CONTINUE = "Do you want continue? y/n";
    private static final String INVALID_VALUE = "Invalid input value";
    private static final String INPUT_BOTTOM_BORDER = "Please input bottom value";
    private static final String INPUT_TOP_BORDER = "Please input top value";
    private static final String INPUT_TREADS_NUMBER = "Please input threads number";
    private static final String OUT_CODE = "n";
    private static final String INVALID_BOTTOM_VALUE = "Bottom value should be in the diapason (2, 10000)";
    private static final String INVALID_TOP_VALUE_DIAPASON = "Top value should be in the diapason (2, 10000)";
    private static final String INVALID_TOP_VALUE = "Top value should be great then Bottom value";
    private static final String INVALID_THREADS_NUMBER = "Threads number should be great then 0";
    private static final int BOTTOM_VALUE = 1;
    private static final int TOP_VALUE = 1000000;

    private int bottomBorder = 0;
    private int topBorder = 0;
    private int threadsNumber = 0;

    private boolean setValues() {
        try {
            setBottomValue();
            setTopValue();
            setThreadsNumberValue();
            return true;
        } catch (NumberFormatException e) {
            LOGGER.error(INVALID_VALUE);
            return false;
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    private void setBottomValue() throws IllegalArgumentException {
        LOGGER.info(INPUT_BOTTOM_BORDER);
        Scanner scanner = new Scanner(System.in);
        bottomBorder = Integer.parseInt(scanner.nextLine());
        if (bottomBorder <= BOTTOM_VALUE) {
            throw new IllegalArgumentException(INVALID_BOTTOM_VALUE);
        }
    }

    private void setTopValue() throws IllegalArgumentException {
        LOGGER.info(INPUT_TOP_BORDER);
        Scanner scanner = new Scanner(System.in);
        topBorder = Integer.parseInt(scanner.nextLine());
        if (topBorder > TOP_VALUE) {
            throw new IllegalArgumentException(INVALID_TOP_VALUE_DIAPASON);
        }
        if (topBorder < bottomBorder) {
            throw new IllegalArgumentException(INVALID_TOP_VALUE);
        }
    }

    private void setThreadsNumberValue() throws IllegalArgumentException {
        LOGGER.info(INPUT_TREADS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        threadsNumber = Integer.parseInt(scanner.nextLine());
        if (threadsNumber <= 0) {
            throw new IllegalArgumentException(INVALID_THREADS_NUMBER);
        }
    }

    /**
     * Method for interaction with user and calling methods that search prime numbers
     */
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        do {
            if (setValues()) {
                SearcherManager searcherManager = new SearcherManager(bottomBorder, topBorder, threadsNumber);
                searcherManager.getPrimeNumbers();
                searcherManager.printPrimeNumbers();
            }
            LOGGER.info(CONTINUE);
        } while (!OUT_CODE.equals(scanner.nextLine()));

        scanner.close();
    }
}
