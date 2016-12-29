package com.epam.mariia_lavrova.java.task8.main;

import com.epam.mariia_lavrova.java.task8.part1.CollectionsUserInteraction;
import com.epam.mariia_lavrova.java.task8.part2.hash.HashMapsContainer;
import com.epam.mariia_lavrova.java.task8.part3.DeviceSerialise;

public class Demo {

    public static void main(String[] args) {

        CollectionsUserInteraction.execute();

        HashMapsContainer.printHashMaps();

        DeviceSerialise deviceSerialise = new DeviceSerialise();
        deviceSerialise.serialise();
        deviceSerialise.deserialize();
    }
}
