/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task8.domain.devices;

import com.epam.mariia_lavrova.java.task8.domain.interfaces.KitchenDevice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class Stove extends HouseholdDevice implements KitchenDevice, Serializable {

    private static final Logger LOGGER = LogManager.getLogger(Stove.class);

    private final static String STOVE = "Stove boils and fries food";
    private static final String FIRE_NUMBER = "\n - Fire number: {}";

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
        LOGGER.info(FIRE_NUMBER, this.getFireNumber());
    }
}
