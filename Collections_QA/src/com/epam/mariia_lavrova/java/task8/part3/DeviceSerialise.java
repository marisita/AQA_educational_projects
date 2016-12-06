package com.epam.mariia_lavrova.java.task8.part3;

import com.epam.mariia_lavrova.java.task8.domain.devices.*;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DeviceSerialise {

    private HouseholdDevice[] householdDevice = new HouseholdDevice[10];

    public DeviceSerialise() {
        householdDevice[0] = new Stove("Stove x3000", 500, 2000, 4);
        householdDevice[1] = new Blender("Blender a8000", 20, 300, 1);
        householdDevice[2] = new Vacuum("Vacuum LG a1", 100, 500, "ionic");
        householdDevice[3] = new WashingMachine("Washing machine", 400, 1000, 12);
    }

    public void serialise() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"));

            for (int i = 0; i < householdDevice.length; i++) {
                if (householdDevice[i] != null) {
                    out.writeUTF("\n" + householdDevice[i].getName());
                    out.writeUTF(String.valueOf(householdDevice[i].getPrice()));
                    out.writeUTF(String.valueOf(householdDevice[i].getPower()));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO exception");
        }

    }
}
