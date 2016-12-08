/**
 * Class for searching prime numbers in the diapason from the bottom border to the top border
 *
 * @author Mariia_Lavrova
 * @since 12/8/2016
 */

package com.epam.mariia_lavrova.java.task9.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeNumbersSearcher extends Thread {
    private AtomicInteger bottomBorder;
    private int topBorder;
    private List<Integer> primeNumbers;

    public PrimeNumbersSearcher(AtomicInteger bottomBorder, int topBorder, List<Integer> primeNumbers) {
        this.bottomBorder = bottomBorder;
        this.topBorder = topBorder;
        this.primeNumbers = primeNumbers;
    }

    /**
     * Method searches prime numbers in the diapason from the bottom border to the top border
     */
    @Override
    public void run() {
        while (bottomBorder.get() < topBorder) {
            int number = bottomBorder.getAndIncrement();
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
