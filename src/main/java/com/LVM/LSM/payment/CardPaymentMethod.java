package com.LVM.LSM.payment;

import com.LVM.LSM.model.Laptop;
import com.LVM.LSM.model.PaymentRequest;
import com.LVM.LSM.model.Receipt;
import com.LVM.LSM.service.LaptopService;
import com.LVM.LSM.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CARD")
public class CardPaymentMethod implements PaymentMethod {

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private ReceiptService receiptService;

    @Override
    public Receipt processPayment(PaymentRequest paymentRequest) {
        // Validate card details
        if (!isValidCardDetails(paymentRequest)) {
            throw new RuntimeException("Invalid card details");
        }

        // Process payment and generate receipt
        Laptop laptop = laptopService.buyLaptop(paymentRequest.getLaptopId());
        return receiptService.generateReceipt(laptop, paymentRequest.getCustomerName(),"CARD");
    }

    private boolean isValidCardDetails(PaymentRequest paymentRequest) {
        // Add logic to validate card details (e.g., expiry date, CVV)
        return paymentRequest.getExpiryDate().matches("(0[1-9]|1[0-2])/\\d{2}") && paymentRequest.getCvv().length() == 3;
    }
}