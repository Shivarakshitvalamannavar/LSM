package com.LVM.LSM.controller;

import com.LVM.LSM.factory.RequestServiceFactory;
import com.LVM.LSM.factory.RequestServiceFactory.RequestType;
import com.LVM.LSM.model.MortgageRequest;
import com.LVM.LSM.service.RequestService;
import com.LVM.LSM.service.MortgageRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mortgage-requests")
public class MortgageRequestController {

    @Autowired
    private RequestServiceFactory requestServiceFactory;

    private RequestService<MortgageRequest> getService() {
        return requestServiceFactory.getService(RequestType.MORTGAGE);
    }

    @PostMapping
    public MortgageRequest createMortgageRequest(@RequestBody MortgageRequest request) {
        return getService().createRequest(request);
    }

    @PutMapping("/{requestId}")
    public MortgageRequest updateMortgageRequestStatus(@PathVariable String requestId, @RequestParam String status) {
        return getService().updateRequestStatus(requestId, status);
    }

    @DeleteMapping("/{requestId}")
    public void deleteMortgageRequest(@PathVariable String requestId) {
        getService().deleteRequest(requestId);
    }

    @GetMapping
    public List<MortgageRequest> getAllMortgageRequests() {
        return getService().getAllRequests();
    }

    @GetMapping("/customer/{customerName}")
    public List<MortgageRequest> getMortgageRequestsByCustomer(@PathVariable String customerName) {
        return ((MortgageRequestService) getService()).getRequestsByCustomerName(customerName);
    }
}