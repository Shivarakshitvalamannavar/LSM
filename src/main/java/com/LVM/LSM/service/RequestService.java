package com.LVM.LSM.service;

import java.util.List;

public interface RequestService<T> {
    T createRequest(T request);
    T updateRequestStatus(String requestId, String status);
    void deleteRequest(String requestId);
    List<T> getAllRequests();
}


