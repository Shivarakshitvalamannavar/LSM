package com.LVM.LSM.controller;

import com.LVM.LSM.factory.RequestServiceFactory;
import com.LVM.LSM.factory.RequestServiceFactory.RequestType; 
import com.LVM.LSM.model.ServiceRequest;
import com.LVM.LSM.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-requests")
public class ServiceRequestController {

    @Autowired
    private RequestServiceFactory requestServiceFactory;

    @PostMapping
    public ServiceRequest createServiceRequest(@RequestBody ServiceRequest request) {
        RequestService<ServiceRequest> service = requestServiceFactory.getService(RequestType.SERVICE);
        return service.createRequest(request);
    }

    @PutMapping("/{requestId}")
    public ServiceRequest updateServiceRequest(@PathVariable String requestId, @RequestParam String status) {
        RequestService<ServiceRequest> service = requestServiceFactory.getService(RequestType.SERVICE);
        return service.updateRequestStatus(requestId, status);
    }

    @DeleteMapping("/{requestId}")
    public void deleteServiceRequest(@PathVariable String requestId) {
        RequestService<ServiceRequest> service = requestServiceFactory.getService(RequestType.SERVICE);
        service.deleteRequest(requestId);
    }

    @GetMapping
    public List<ServiceRequest> getAllServiceRequests() {
        RequestService<ServiceRequest> service = requestServiceFactory.getService(RequestType.SERVICE);
        return service.getAllRequests();
    }
}