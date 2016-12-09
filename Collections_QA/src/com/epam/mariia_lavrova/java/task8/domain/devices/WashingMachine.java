/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task8.domain.devices;

import com.epam.mariia_lavrova.java.task8.domain.interfaces.CleaningDevice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class WashingMachine extends HouseholdDevice implements CleaningDevice, Serializable {

    private static final Logger LOGGER = LogManager.getLogger(WashingMachine.class);

    private final static String WASHING_MACHINE = "Washing machine cleans closes";
    private static final String OPTIONS_NUMBER = "\n - Options number: {}";

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
        LOGGER.info(WASHING_MACHINE);
    }

    @Override
    public void printDeviceCharacteristics() {
        super.printDeviceCharacteristics();
        LOGGER.info(OPTIONS_NUMBER, this.getOptionsNumber());
    }
}
