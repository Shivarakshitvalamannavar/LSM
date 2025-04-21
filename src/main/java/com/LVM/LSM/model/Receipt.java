package com.LVM.LSM.model;

public class Receipt {
    private String receiptId;
    private String laptopId;
    private String laptopModel;
    private double price;
    private String customerName;
    private String date;
    private String paymentType;

    // Private constructor to enforce the use of the Builder
    private Receipt(Builder builder) {
        this.receiptId = builder.receiptId;
        this.laptopId = builder.laptopId;
        this.laptopModel = builder.laptopModel;
        this.price = builder.price;
        this.customerName = builder.customerName;
        this.date = builder.date;
        this.paymentType = builder.paymentType;
    }

    // Getters
    public String getReceiptId() {
        return receiptId;
    }

    public String getLaptopId() {
        return laptopId;
    }

    public String getLaptopModel() {
        return laptopModel;
    }

    public double getPrice() {
        return price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    // Static Builder class
    public static class Builder {
        private String receiptId;
        private String laptopId;
        private String laptopModel;
        private double price;
        private String customerName;
        private String date;
        private String paymentType;

        public Builder receiptId(String receiptId) {
            this.receiptId = receiptId;
            return this;
        }

        public Builder laptopId(String laptopId) {
            this.laptopId = laptopId;
            return this;
        }

        public Builder laptopModel(String laptopModel) {
            this.laptopModel = laptopModel;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder paymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Receipt build() {
            return new Receipt(this);
        }
    }
}