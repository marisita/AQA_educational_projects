/**
 * Class for using calculator and hierarchy of Household devices
 *
 * @author Mariia_Lavrova
 * @since 11/24/2016
 */

package com.epam.mariia_lavrova.java.task4.main;

import com.epam.mariia_lavrova.java.task4.part1.container.DeviceContainer;
import com.epam.mariia_lavrova.java.task4.part1.devices.*;
import com.epam.mariia_lavrova.java.task4.part2.calculator.Calculator;


public class Demo {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.calculate();


        Stove stove = new Stove("Stove x3000", 500, 2000, 4);
        Blender blender = new Blender("Blender a8000", 20, 300, 1);
        Vacuum vacuum = new Vacuum("Vacuum LG a1", 100, 500, "ionic");
        WashingMachine washingMachine = new WashingMachine("Washing machine", 400, 1000, 12);

        stove.printDeviceCharacteristics();
        stove.plugIn();
        stove.printIsPluggedIn();
        stove.prepareFood();

        blender.printDeviceCharacteristics();
        blender.prepareFood();

        vacuum.printDeviceCharacteristics();
        vacuum.plugIn();
        vacuum.printIsPluggedIn();
        vacuum.clean();
        vacuum.plugOut();

        washingMachine.printDeviceCharacteristics();
        washingMachine.clean();

        HouseholdDevice[] householdDevices = new HouseholdDevice[4];
        householdDevices[0] = stove;
        householdDevices[1] = blender;
        householdDevices[2] = vacuum;
        householdDevices[3] = washingMachine;
        DeviceContainer deviceContainer = new DeviceContainer(householdDevices);

        System.out.println("\n\nSorted devices: ");
        householdDevices = deviceContainer.sortByPower(householdDevices);
        deviceContainer.printDevices(householdDevices);


        int firstPrice = 10;
        int secondPrice = 100;

        System.out.println("\n\nFiltered devices:");
        HouseholdDevice[] filteredHouseholdDevices = deviceContainer.filterByPrice(firstPrice, secondPrice);
        deviceContainer.printDevices(filteredHouseholdDevices);

    }
}
