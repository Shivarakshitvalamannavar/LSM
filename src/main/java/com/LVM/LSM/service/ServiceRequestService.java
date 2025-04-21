package com.LVM.LSM.service;

import com.LVM.LSM.model.ServiceRequest;
import com.LVM.LSM.model.ServiceRequestStatus;
import com.LVM.LSM.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService implements RequestService<ServiceRequest> {

    @Autowired
    private ServiceRequestRepository repository;

    @Override
    public ServiceRequest createRequest(ServiceRequest request) {
        request.setStatus(ServiceRequestStatus.RECEIVED);
        return repository.save(request);
    }

    @Override
    public ServiceRequest updateRequestStatus(String requestId, String status) {
        ServiceRequest request = repository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus(ServiceRequestStatus.valueOf(status));
        return repository.save(request);
    }

    @Override
    public void deleteRequest(String requestId) {
        repository.deleteById(requestId);
    }

    @Override
    public List<ServiceRequest> getAllRequests() {
        return repository.findAll();
    }
}