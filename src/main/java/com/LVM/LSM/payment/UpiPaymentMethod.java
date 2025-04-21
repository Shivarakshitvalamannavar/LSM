package com.LVM.LSM.payment;

import com.LVM.LSM.model.Laptop;
import com.LVM.LSM.model.PaymentRequest;
import com.LVM.LSM.model.Receipt;
import com.LVM.LSM.service.LaptopService;
import com.LVM.LSM.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UPI")
public class UpiPaymentMethod implements PaymentMethod {

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private ReceiptService receiptService;

    @Override
    public Receipt processPayment(PaymentRequest paymentRequest) {
        // Validate UPI ID
        if (!isValidUpiId(paymentRequest.getUpiId())) {
            throw new RuntimeException("Invalid UPI ID");
        }

        // Process payment and generate receipt
        Laptop laptop = laptopService.buyLaptop(paymentRequest.getLaptopId());
        return receiptService.generateReceipt(laptop, paymentRequest.getCustomerName(),"UPI");
    }

    private boolean isValidUpiId(String upiId) {
        // Add logic to validate UPI ID (e.g., format: user@bank)
        return upiId != null && upiId.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+$");
    }
}