/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task8.domain.devices;

import com.epam.mariia_lavrova.java.task8.domain.interfaces.KitchenDevice;

import java.io.Serializable;

public class Stove extends HouseholdDevice implements KitchenDevice, Serializable {

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
