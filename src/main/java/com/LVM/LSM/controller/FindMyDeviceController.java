package com.LVM.LSM.controller;

import com.LVM.LSM.factory.RequestServiceFactory;
import com.LVM.LSM.factory.RequestServiceFactory.RequestType;
import com.LVM.LSM.model.FindMyDeviceRequest;
import com.LVM.LSM.service.RequestService;
import com.LVM.LSM.service.FindMyDeviceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/find-my-device")
public class FindMyDeviceController {

    @Autowired
    private RequestServiceFactory requestServiceFactory;

    private RequestService<FindMyDeviceRequest> getService() {
        return requestServiceFactory.getService(RequestType.FIND_MY_DEVICE);
    }

    @PostMapping
    public FindMyDeviceRequest createFindMyDeviceRequest(@RequestBody FindMyDeviceRequest request) {
        return getService().createRequest(request);
    }

    @PutMapping("/{requestId}")
    public FindMyDeviceRequest updateFindMyDeviceRequestStatus(@PathVariable String requestId, @RequestParam String status) {
        return getService().updateRequestStatus(requestId, status);
    }

    @DeleteMapping("/{requestId}")
    public void deleteFindMyDeviceRequest(@PathVariable String requestId) {
        getService().deleteRequest(requestId);
    }

    @GetMapping
    public List<FindMyDeviceRequest> getAllFindMyDeviceRequests() {
        return getService().getAllRequests();
    }

    @GetMapping("/customer/{customerName}")
    public List<FindMyDeviceRequest> getFindMyDeviceRequestsByCustomer(@PathVariable String customerName) {
        return ((FindMyDeviceRequestService) getService()).getRequestsByCustomerName(customerName);
    }
}