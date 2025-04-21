package com.LVM.LSM.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mortgage_requests")
public class MortgageRequest {
    @Id
    private String requestId;
    private String customerName; // Changed from customerId to customerName
    private String laptopModel;
    private int yearsUsed;
    private String issues;
    private double price;
    private MortgageRequestStatus status;

    // Getters and Setters
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLaptopModel() {
        return laptopModel;
    }

    public void setLaptopModel(String laptopModel) {
        this.laptopModel = laptopModel;
    }

    public int getYearsUsed() {
        return yearsUsed;
    }

    public void setYearsUsed(int yearsUsed) {
        this.yearsUsed = yearsUsed;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MortgageRequestStatus getStatus() {
        return status;
    }

    public void setStatus(MortgageRequestStatus status) {
        this.status = status;
    }
}