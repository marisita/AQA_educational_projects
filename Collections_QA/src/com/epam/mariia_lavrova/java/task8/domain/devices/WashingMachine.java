/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task8.domain.devices;

import com.epam.mariia_lavrova.java.task8.domain.interfaces.CleaningDevice;

import java.io.Serializable;

public class WashingMachine extends HouseholdDevice implements CleaningDevice, Serializable {

    private final static String WASHING_MACHINE = "Washing machine cleans closes";

    private int optionsNumber;

    public int getOptionsNumber() {
        return optionsNumber;
    }

    public void setOptionsNumber(int optionsNumber) {
        this.optionsNumber = optionsNumber;
    }

    public WashingMachine(String name, double price, int power, int optionsNumber) {
        super(name, price, power);
        this.optionsNumber = optionsNumber;
    }

    @Override
    public void clean() {
        System.out.println(WASHING_MACHINE);
    }

    @Override
    public void printDeviceCharacteristics() {
        super.printDeviceCharacteristics();
        System.out.println(" - Options number: " + getOptionsNumber());
    }
}
