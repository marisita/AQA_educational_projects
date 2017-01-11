/**
 * Class for multithreaded searching prime numbers in the diapason from the bottom border to the top border
 *
 * @author Mariia_Lavrova
 * @since 12/8/2016
 */

package com.epam.mariia_lavrova.java.task9.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SearcherManager {

    private static final Logger LOGGER = LogManager.getLogger(SearcherManager.class);

    private static final String PRIME_NUMBERS_OUTPUT = "Prime numbers in diapason ({}, {}) is {}";
    private static final String MILLISECONDS_PASSED = "Milliseconds passed: ";

    private AtomicInteger bottomBorderSynchronized;
    private int bottomBorder;
    private int topBorder;
    private int threadsNumber;
    private List<Integer> primeNumbers;

    public SearcherManager(int bottomBorder, int topBorder, int threadsNumber) {
        this.bottomBorderSynchronized = new AtomicInteger(bottomBorder);
        this.bottomBorder = bottomBorder;
        this.topBorder = topBorder;
        this.threadsNumber = threadsNumber;
        this.primeNumbers = Collections.synchronizedList(new ArrayList<>());
    }

    /**
     * Method searches prime numbers in the diapason from the bottom border to the top border in threadNumbers threads
     * and prints the number of passed milliseconds for searching
     *
     * @return a list of prime numbers
     */
    public List<Integer> getPrimeNumbers() {

        PrimeNumbersSearcher[] searchers = new PrimeNumbersSearcher[threadsNumber];
        for (int i = 0; i < threadsNumber; i++) {
            searchers[i] = new PrimeNumbersSearcher(bottomBorderSynchronized, topBorder, primeNumbers);
            searchers[i].start();
        }
        long startTime = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < threadsNumber; i++) {
            try {
                searchers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = Calendar.getInstance().getTimeInMillis();

        LOGGER.info(MILLISECONDS_PASSED + (endTime - startTime));
        return primeNumbers;
    }

    /**
     * Method prints the prime numbers that was searched
     */
    public void printPrimeNumbers() {
        if (!primeNumbers.isEmpty()) {
            String outputPrimeNumbers = "{ ";
            for (int number : primeNumbers) {
                outputPrimeNumbers = outputPrimeNumbers.concat(number + " ");
            }
            outputPrimeNumbers += "} ";
            LOGGER.info(PRIME_NUMBERS_OUTPUT, bottomBorder, topBorder, outputPrimeNumbers);
        }
    }
}
