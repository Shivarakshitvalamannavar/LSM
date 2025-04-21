package com.LVM.LSM.factory;

import com.LVM.LSM.service.RequestService;
import com.LVM.LSM.service.ServiceRequestService;
import com.LVM.LSM.service.MortgageRequestService;
import com.LVM.LSM.service.FindMyDeviceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestServiceFactory {

    @Autowired
    private ServiceRequestService serviceRequestService;

    @Autowired
    private MortgageRequestService mortgageRequestService;

    @Autowired
    private FindMyDeviceRequestService findMyDeviceRequestService;

    @SuppressWarnings("unchecked")
    public <T> RequestService<T> getService(RequestType type) {
        switch (type) {
            case SERVICE:
                return (RequestService<T>) serviceRequestService;
            case MORTGAGE:
                return (RequestService<T>) mortgageRequestService;
            case FIND_MY_DEVICE:
                return (RequestService<T>) findMyDeviceRequestService;
            default:
                throw new IllegalArgumentException("Unknown request type: " + type);
        }
    }

    public enum RequestType{
        SERVICE,
        MORTGAGE,
        FIND_MY_DEVICE
    }
}