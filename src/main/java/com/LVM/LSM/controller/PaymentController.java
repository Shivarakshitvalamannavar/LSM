package com.LVM.LSM.controller;

import com.LVM.LSM.model.PaymentRequest;
import com.LVM.LSM.model.Receipt;
import com.LVM.LSM.payment.PaymentMethod;
import com.LVM.LSM.factory.PaymentMethodFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentMethodFactory paymentMethodFactory;

    @PostMapping("/process")
    public Receipt processPayment(@RequestBody PaymentRequest paymentRequest) {
        // Get the appropriate payment method
        PaymentMethod paymentMethod = paymentMethodFactory.getPaymentMethod(paymentRequest.getPaymentMethod());

        // Process the payment
        return paymentMethod.processPayment(paymentRequest);
    }
}