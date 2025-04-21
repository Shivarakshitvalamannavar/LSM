package com.LVM.LSM.repository;

import com.LVM.LSM.model.FindMyDeviceRequest;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FindMyDeviceRequestRepository extends MongoRepository<FindMyDeviceRequest, String> {
    List<FindMyDeviceRequest> findByCustomerName(String customerName);
}