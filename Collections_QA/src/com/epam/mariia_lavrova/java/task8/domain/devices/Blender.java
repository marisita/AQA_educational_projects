/**
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task8.domain.devices;
import com.epam.mariia_lavrova.java.task8.domain.interfaces.KitchenDevice;

import java.io.Serializable;

public class Blender extends HouseholdDevice implements KitchenDevice, Serializable{

    private final static String BLENDER = "Blender cut and shake food";

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
        System.out.println(BLENDER);
    }

    @Override
    public void printDeviceCharacteristics() {
        super.printDeviceCharacteristics();
        System.out.println(" - Cup volume: " + getCupVolume() + " l");
    }
}
