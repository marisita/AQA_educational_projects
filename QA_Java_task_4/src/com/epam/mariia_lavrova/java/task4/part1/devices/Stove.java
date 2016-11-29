/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task4.part1.devices;

import com.epam.mariia_lavrova.java.task4.part1.interfaces.KitchenDevice;


public class Stove extends HouseholdDevice implements KitchenDevice {

    private final static String STOVE = "Stove boils and fries food";

    private int fireNumber;

    public int getFireNumber() {
        return fireNumber;
    }

    public void setFireNumber(int fireNumber) {
        this.fireNumber = fireNumber;
    }

    public Stove(String name, double price, int power, int fireNumber) {
        super(name, price, power);
        this.fireNumber = fireNumber;
    }

    @Override
    public void prepareFood() {
        System.out.println(STOVE);
    }

    @Override
    public void printDeviceCharacteristics() {
        super.printDeviceCharacteristics();
        System.out.println(" - Fire number: " + this.getFireNumber());
    }
}
