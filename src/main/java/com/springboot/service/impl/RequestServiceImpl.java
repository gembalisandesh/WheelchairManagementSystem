package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ENUM.RequestStatus;
import com.springboot.model.Request;
import com.springboot.repository.RequestRepository;
import com.springboot.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public Request save(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public List<Request> findByCustomerEmail(String customerEmail) {
        return requestRepository.findByCustomerEmail(customerEmail);
    }

    @Override
    public List<Request> findByStatus(RequestStatus status) {
        return requestRepository.findByStatus(status);
    }

    @Override
    public Request findById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid request ID"));
    }

    @Override
    public void updateStatus(Long requestId, RequestStatus status) {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid request ID"));
        request.setStatus(status);
        requestRepository.save(request);
    }

}