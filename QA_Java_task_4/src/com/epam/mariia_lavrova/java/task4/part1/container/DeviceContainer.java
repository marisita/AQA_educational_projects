/**
 * Class for containing, sorting and filtering devices
 * @author Mariia_Lavrova
 * @since 11/26/2016
 */

package com.epam.mariia_lavrova.java.task4.part1.container;
import com.epam.mariia_lavrova.java.task4.part1.devices.HouseholdDevice;

public class DeviceContainer {

    private HouseholdDevice[] householdDevices;

    public DeviceContainer(HouseholdDevice[] householdDevices) {
        this.householdDevices = householdDevices;
    }


    public HouseholdDevice[] sortByPower(HouseholdDevice[] householdDevices) {

        for (int i = 0; i < householdDevices.length - 1; i++) {
            for (int j = 0; j < householdDevices.length - 1; j++) {
                if (householdDevices[j].getPower() > householdDevices[j + 1].getPower()) {
                    HouseholdDevice temp = householdDevices[j];
                    householdDevices[j] = householdDevices[j + 1];
                    householdDevices[j + 1] = temp;
                }
            }
        }

        return householdDevices;
    }


    public HouseholdDevice[] filterByPrice(double firstPrice, double secondPrice) {

        HouseholdDevice[] filteredHouseholdDevices = new HouseholdDevice[householdDevices.length];

        int filteredIndex = 0;

        for (int i = 0; i < householdDevices.length; i++) {
            if (householdDevices[i].getPrice() >= firstPrice && householdDevices[i].getPrice() <= secondPrice) {
                filteredHouseholdDevices[filteredIndex] = householdDevices[i];
                filteredIndex++;
            }
        }

        return filteredHouseholdDevices;
    }


    public void printDevices(HouseholdDevice[] householdDevices) {
        for (int i = 0; i < householdDevices.length; i++) {
            if (householdDevices[i] != null) {
                householdDevices[i].printDeviceCharacteristics();
            }
        }
    }
}
