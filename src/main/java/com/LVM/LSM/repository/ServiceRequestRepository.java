package com.LVM.LSM.repository;

import com.LVM.LSM.model.ServiceRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceRequestRepository extends MongoRepository<ServiceRequest, String> {
}
