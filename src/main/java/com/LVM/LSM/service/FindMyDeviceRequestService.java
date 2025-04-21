package com.LVM.LSM.service;

import com.LVM.LSM.model.FindMyDeviceRequest;
import com.LVM.LSM.repository.FindMyDeviceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindMyDeviceRequestService implements RequestService<FindMyDeviceRequest> {

    @Autowired
    private FindMyDeviceRequestRepository findMyDeviceRequestRepository;

    @Override
    public FindMyDeviceRequest createRequest(FindMyDeviceRequest request) {
        request.setStatus("NOT_FOUND"); // Default status
        return findMyDeviceRequestRepository.save(request);
    }

    @Override
    public FindMyDeviceRequest updateRequestStatus(String requestId, String status) {
        FindMyDeviceRequest request = findMyDeviceRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus(status);
        return findMyDeviceRequestRepository.save(request);
    }

    @Override
    public void deleteRequest(String requestId) {
        findMyDeviceRequestRepository.deleteById(requestId);
    }

    @Override
    public List<FindMyDeviceRequest> getAllRequests() {
        return findMyDeviceRequestRepository.findAll();
    }

    public List<FindMyDeviceRequest> getRequestsByCustomerName(String customerName) {
        return findMyDeviceRequestRepository.findByCustomerName(customerName);
    }
}