package com.LVM.LSM.service;

import com.LVM.LSM.model.Laptop;
import com.LVM.LSM.model.Receipt;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class ReceiptService {

    public Receipt generateReceipt(Laptop laptop, String customerName, String paymentType) {
        return new Receipt.Builder()
                .receiptId(UUID.randomUUID().toString())
                .laptopId(laptop.getLaptopId())
                .laptopModel(laptop.getModel())
                .price(1000.00) // Mock price, replace with actual logic if needed
                .customerName(customerName)
                .date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .paymentType(paymentType)
                .build();
    }
}