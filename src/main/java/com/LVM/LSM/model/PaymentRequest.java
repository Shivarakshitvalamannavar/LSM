package com.LVM.LSM.model;

public class PaymentRequest {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String laptopId;
    private String customerName;
    private String upiId; // For UPI payments
    private String paymentMethod; // CARD or UPI

    // Getters and Setters
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    public String getLaptopId() { return laptopId; }
    public void setLaptopId(String laptopId) { this.laptopId = laptopId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getUpiId() { return upiId; }
    public void setUpiId(String upiId) { this.upiId = upiId; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}