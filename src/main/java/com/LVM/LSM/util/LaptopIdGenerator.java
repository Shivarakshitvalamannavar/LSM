package com.LVM.LSM.util;

import java.util.UUID;

public class LaptopIdGenerator {

    // Static instance of the class
    private static LaptopIdGenerator instance;

    // Private constructor to prevent instantiation
    private LaptopIdGenerator() {}

    // Public method to provide access to the instance
    public static synchronized LaptopIdGenerator getInstance() {
        if (instance == null) {
            instance = new LaptopIdGenerator();
        }
        return instance;
    }

    // Method to generate a unique ID
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}