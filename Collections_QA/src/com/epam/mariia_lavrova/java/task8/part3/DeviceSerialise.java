package com.epam.mariia_lavrova.java.task8.part3;

import com.epam.mariia_lavrova.java.task8.domain.devices.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceSerialise implements Serializable {

    private static final Logger LOGGER = LogManager.getLogger(DeviceSerialise.class);

    private List<HouseholdDevice> householdDevices = new ArrayList<>();

    public DeviceSerialise() {
        householdDevices.add(new Stove("Stove x3000", 500, 2000, 4));
        householdDevices.add(new Stove("Stove x3000", 500, 2000, 4));
        householdDevices.add(new Blender("Blender a8000", 20, 300, 1));
        householdDevices.add(new Vacuum("Vacuum LG a1", 100, 500, "ionic"));
        householdDevices.add(new WashingMachine("Washing machine", 400, 1000, 12));
    }

    public void serialise() {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("output.txt"));

            for (HouseholdDevice householdDevice : householdDevices) {
                oos.writeObject(householdDevice);
            }

            oos.close();

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void deserialize() {

        try {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("output.txt"));
            HouseholdDevice householdDevice;

            while ((householdDevice = (HouseholdDevice) oin.readObject()) != null) {
                householdDevice.printDeviceCharacteristics();
            }

            oin.close();

        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
