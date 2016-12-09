/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task8.domain.devices;

import com.epam.mariia_lavrova.java.task8.domain.interfaces.CleaningDevice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class Vacuum extends HouseholdDevice implements CleaningDevice, Serializable {

    private static final Logger LOGGER = LogManager.getLogger(Vacuum.class);

    private final static String VACUUM = "Vacuum cleans floors and carpet";
    private static final String FILTER_TYPE = "\n - FilterType: {}";

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
        LOGGER.info(VACUUM);
    }

    @Override
    public void printDeviceCharacteristics() {
        super.printDeviceCharacteristics();
        LOGGER.info(FILTER_TYPE, this.getFilterType());
    }
}
