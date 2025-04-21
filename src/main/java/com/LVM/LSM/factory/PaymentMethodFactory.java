package com.LVM.LSM.factory;

import com.LVM.LSM.payment.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentMethodFactory {

    private final Map<String, PaymentMethod> paymentMethods;

    @Autowired
    public PaymentMethodFactory(Map<String, PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public PaymentMethod getPaymentMethod(String method) {
        PaymentMethod paymentMethod = paymentMethods.get(method.toUpperCase());
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + method);
        }
        return paymentMethod;
    }
}