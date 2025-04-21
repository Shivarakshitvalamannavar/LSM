package com.LVM.LSM.payment;

import com.LVM.LSM.model.PaymentRequest;
import com.LVM.LSM.model.Receipt;
public interface PaymentMethod {
    Receipt processPayment(PaymentRequest paymentRequest);
} 
