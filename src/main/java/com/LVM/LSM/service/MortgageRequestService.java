package com.LVM.LSM.service;

import com.LVM.LSM.model.MortgageRequest;
import com.LVM.LSM.model.MortgageRequestStatus;
import com.LVM.LSM.repository.MortgageRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MortgageRequestService implements RequestService<MortgageRequest> {

    @Autowired
    private MortgageRequestRepository mortgageRequestRepository;

    @Override
    public MortgageRequest createRequest(MortgageRequest request) {
        request.setStatus(MortgageRequestStatus.IN_PROCESS); // Default status
        return mortgageRequestRepository.save(request);
    }

    @Override
    public MortgageRequest updateRequestStatus(String requestId, String status) {
        MortgageRequest request = mortgageRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus(MortgageRequestStatus.valueOf(status));
        return mortgageRequestRepository.save(request);
    }

    @Override
    public void deleteRequest(String requestId) {
        mortgageRequestRepository.deleteById(requestId);
    }

    @Override
    public List<MortgageRequest> getAllRequests() {
        return mortgageRequestRepository.findAll();
    }

    public List<MortgageRequest> getRequestsByCustomerName(String customerName) {
        return mortgageRequestRepository.findByCustomerName(customerName);
    }
}