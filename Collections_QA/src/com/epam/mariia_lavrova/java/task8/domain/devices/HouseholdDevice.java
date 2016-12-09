/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task8.domain.devices;
import com.epam.mariia_lavrova.java.task8.domain.interfaces.ElectricalDevice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public abstract class HouseholdDevice implements ElectricalDevice, Serializable {

    private static final Logger LOGGER = LogManager.getLogger(HouseholdDevice.class);

    private final static String DEVICE_IS_PLUGGED = "Device is plugged in";
    private final static String DEVICE_IS_NOT_PLUGGED = "Device is not plugged in";
    private final static String YOU_PLUG_IN_DEVICE = "You plug in this device";
    private final static String YOU_PLUG_OUT_DEVICE = "You plug out this device";
    private final static String DEVICE_CHARACTERISTICS = "\nDevice characteristics: \n - Name:  {} \n - Price:  {} $ \n - Power: {} W";

    private String name;
    private transient double price;
    private boolean pluggedIn;
    private static int power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isPluggedIn() {
        return pluggedIn;
    }

    public HouseholdDevice(String name, double price, int power) {
        this.name = name;
        this.price = price;
        this.power = power;
    }

    public void printIsPluggedIn() {
        if (isPluggedIn()) {
            LOGGER.info(DEVICE_IS_PLUGGED);
        } else {
            LOGGER.info(DEVICE_IS_NOT_PLUGGED);
        }
    }

    @Override
    public void plugIn() {
        this.pluggedIn = true;
        LOGGER.info(YOU_PLUG_IN_DEVICE);
    }

    @Override
    public void plugOut() {
        this.pluggedIn = false;
        LOGGER.info(YOU_PLUG_OUT_DEVICE);
    }

    @Override
    public void printDeviceCharacteristics() {
        LOGGER.info(DEVICE_CHARACTERISTICS, name, price, power);
    }

    @Override
    public String toString() {
        return "{" + getName() + " " + getPrice() + "$ " + getPower() + "W}";
    }
}
