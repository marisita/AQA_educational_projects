package com.epam.mariia_lavrova.java.task4.part2.operations;

/**
 * Created by Mariia_Lavrova on 11/24/2016.
 */
public class Division implements Operation {

    @Override
    public double execute(int a, int b) {

        double divisionResult;

        try{
            divisionResult = (double) a / b;
        } catch (ArithmeticException e) {
            //System.out.println(WRONG_OPERATION);
            divisionResult = 0;
        }

        return divisionResult;
    }
}
