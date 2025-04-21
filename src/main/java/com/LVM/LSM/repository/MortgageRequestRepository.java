package com.LVM.LSM.repository;

import com.LVM.LSM.model.MortgageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MortgageRequestRepository extends MongoRepository<MortgageRequest, String> {
    List<MortgageRequest> findByCustomerName(String customerName); // Changed from customerId to customerName
}