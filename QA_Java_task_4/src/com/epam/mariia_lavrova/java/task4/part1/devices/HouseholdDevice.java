/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task4.part1.devices;
import com.epam.mariia_lavrova.java.task4.part1.interfaces.ElectricalDevice;

public abstract class HouseholdDevice implements ElectricalDevice {

    private final static String DEVICE_IS_PLUGGED = "Device is plugged in";
    private final static String DEVICE_IS_NOT_PLUGGED = "Device is not plugged in";
    private final static String YOU_PLUG_IN_DEVICE = "You plug in this device";
    private final static String YOU_PLUG_OUT_DEVICE = "You plug out this device";
    private final static String DEVICE_CHARACTERISTICS = "\nDevice characteristics: ";

    private String name;
    private double price;
    private boolean pluggedIn;
    private int power;

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
            System.out.println(DEVICE_IS_PLUGGED);
        } else {
            System.out.println(DEVICE_IS_NOT_PLUGGED);
        }
    }

    @Override
    public void plugIn() {
        this.pluggedIn = true;
        System.out.println(YOU_PLUG_IN_DEVICE);
    }

    @Override
    public void plugOut() {
        this.pluggedIn = false;
        System.out.println(YOU_PLUG_OUT_DEVICE);
    }

    @Override
    public void printDeviceCharacteristics() {
        System.out.println(DEVICE_CHARACTERISTICS);
        System.out.println(" - Name: " + getName());
        System.out.println(" - Price: " + getPrice() + " $");
        System.out.println(" - Power: " + getPower() + " W");
    }
}
