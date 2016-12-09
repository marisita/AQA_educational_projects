package com.epam.mariia_lavrova.java.task8.part2.hash;

import com.epam.mariia_lavrova.java.task8.domain.devices.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapsContainer {

    private static final Logger LOGGER = LogManager.getLogger(HashMapsContainer.class);

    private static final String DEVISES_HASH_MAP_LENGTH = "Devises hash map with hash as length: ";
    private static final String DEVISES_LINKED_HASH_MAP_LENGTH = "Devises linked hash map with hash as length: ";
    private static final String DEVISES_HASH_MAP_SUM = "Devises hash map with hash as first tree number sum: ";
    private static final String DEVISES_LINKED_HASH_MAP_SUM = "Devises linked hash map with hash as first tree number sum: ";

    public static void printHashMaps() {

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

        LOGGER.info(DEVISES_HASH_MAP_LENGTH + devicesHashAsLength);
        LOGGER.info(DEVISES_LINKED_HASH_MAP_LENGTH + devicesHashAsLengthLinked);
        LOGGER.info(DEVISES_HASH_MAP_SUM + devicesHashAsSum);
        LOGGER.info(DEVISES_LINKED_HASH_MAP_SUM + devicesHashAsSumLinked);
    }
}
