package com.LVM.LSM.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "laptops")
public class Laptop {
    @Id
    private String laptopId;
    private String model;
    private LaptopStatus status;
    private int quantity; // New field to track stock

    // Getters and Setters
    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LaptopStatus getStatus() {
        return status;
    }

    public void setStatus(LaptopStatus status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}