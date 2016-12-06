package com.epam.mariia_lavrova.java.task8.main;

import com.epam.mariia_lavrova.java.task8.domain.devices.*;
import com.epam.mariia_lavrova.java.task8.part1.UserUtilPart1;
import com.epam.mariia_lavrova.java.task8.part2.hash.*;
import com.epam.mariia_lavrova.java.task8.part3.DeviceSerialise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {

        UserUtilPart1.execute();

        String vendorCode1 = "338389";
        String vendorCode2 = "1234561";
        String vendorCode3 = "686828882";
        String vendorCode4 = "8258";

        Stove stove = new Stove("Stove x3000", 500, 2000, 4);
        Blender blender = new Blender("Blender a8000", 20, 300, 1);
        Vacuum vacuum = new Vacuum("Vacuum LG a1", 100, 500, "ionic");
        WashingMachine washingMachine = new WashingMachine("Washing machine", 400, 1000, 12);

        Map<Integer, HouseholdDevice> devicesHashAsLength = new HashMap<>();
        Map<Integer, HouseholdDevice> devicesHashAsLengthLinked = new LinkedHashMap<>();
        Map<Integer, HouseholdDevice> devicesHashAsSum = new HashMap<>();
        Map<Integer, HouseholdDevice> devicesHashAsSumLinked = new LinkedHashMap<>();

        devicesHashAsLength.put(new HashBuilderAsLength(vendorCode1).hashCode(), stove);
        devicesHashAsLength.put(new HashBuilderAsLength(vendorCode2).hashCode(), blender);
        devicesHashAsLength.put(new HashBuilderAsLength(vendorCode3).hashCode(), vacuum);
        devicesHashAsLength.put(new HashBuilderAsLength(vendorCode4).hashCode(), washingMachine);

        devicesHashAsLengthLinked.put(new HashBuilderAsLength(vendorCode1).hashCode(), stove);
        devicesHashAsLengthLinked.put(new HashBuilderAsLength(vendorCode2).hashCode(), blender);
        devicesHashAsLengthLinked.put(new HashBuilderAsLength(vendorCode3).hashCode(), vacuum);
        devicesHashAsLengthLinked.put(new HashBuilderAsLength(vendorCode4).hashCode(), washingMachine);

        devicesHashAsSum.put(new HashBuilderAsSum(vendorCode1).hashCode(), stove);
        devicesHashAsSum.put(new HashBuilderAsSum(vendorCode2).hashCode(), blender);
        devicesHashAsSum.put(new HashBuilderAsSum(vendorCode3).hashCode(), vacuum);
        devicesHashAsSum.put(new HashBuilderAsSum(vendorCode4).hashCode(), washingMachine);

        devicesHashAsSumLinked.put(new HashBuilderAsSum(vendorCode1).hashCode(), stove);
        devicesHashAsSumLinked.put(new HashBuilderAsSum(vendorCode2).hashCode(), blender);
        devicesHashAsSumLinked.put(new HashBuilderAsSum(vendorCode3).hashCode(), vacuum);
        devicesHashAsSumLinked.put(new HashBuilderAsSum(vendorCode4).hashCode(), washingMachine);

        System.out.println("\nDevises hash map with hash as length: \n " + devicesHashAsLength);
        System.out.println("\nDevises linked hash map with hash as length: \n " + devicesHashAsLengthLinked);
        System.out.println("\nDevises hash map with hash as first tree number sum: \n " + devicesHashAsSum);
        System.out.println("\nDevises linked hash map with hash as first tree number sum: \n " + devicesHashAsSumLinked);

        DeviceSerialise deviceSerialise = new DeviceSerialise();
        deviceSerialise.serialise();
    }
}
