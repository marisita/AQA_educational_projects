/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task8.domain.devices;
import com.epam.mariia_lavrova.java.task8.domain.interfaces.KitchenDevice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class Blender extends HouseholdDevice implements KitchenDevice, Serializable{

    private static final Logger LOGGER = LogManager.getLogger(Blender.class);

    private final static String BLENDER = "Blender cut and shake food";
    private final static String CUP_VOLUME = "\n - Cup volume: {} l";

    private double cupVolume;

    public double getCupVolume() {
        return cupVolume;
    }

    public void setCupVolume(double cupVolume) {
        this.cupVolume = cupVolume;
    }

    public Blender(String name, double price, int power, double cupVolume) {
        super(name, price, power);
        this.cupVolume = cupVolume;
    }

    @Override
    public void prepareFood() {
        LOGGER.info(BLENDER);
    }

    @Override
    public void printDeviceCharacteristics() {
        super.printDeviceCharacteristics();
        LOGGER.info(CUP_VOLUME, this.getCupVolume());
    }
}
