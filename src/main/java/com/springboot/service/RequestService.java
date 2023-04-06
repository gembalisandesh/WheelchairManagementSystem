package com.springboot.service;

import java.util.List;

import com.springboot.ENUM.RequestStatus;
import com.springboot.model.Request;

public interface RequestService {
    Request save(Request request);
    List<Request> findByCustomerEmail(String customerEmail);
    List<Request> findByStatus(RequestStatus status);
    Request findById(Long id);
    void updateStatus(Long requestId, RequestStatus status);
}