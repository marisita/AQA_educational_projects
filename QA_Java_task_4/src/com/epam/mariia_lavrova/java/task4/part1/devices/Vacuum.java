/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task4.part1.devices;
import com.epam.mariia_lavrova.java.task4.part1.interfaces.CleaningDevice;

public class Vacuum extends HouseholdDevice implements CleaningDevice {

    private final static String VACUUM = "Vacuum cleans floors and carpet";

    private String filterType;

    public String getFilterType() {

        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public Vacuum(String name, double price, int power, String filterType) {
        super(name, price, power);
        this.filterType = filterType;
    }

    @Override
    public void clean() {
        System.out.println(VACUUM);
    }

    @Override
    public void printDeviceCharacteristics() {
        super.printDeviceCharacteristics();
        System.out.println(" - FilterType: " + getFilterType());
    }
}
