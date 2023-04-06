package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ENUM.RequestStatus;
import com.springboot.model.Request;



@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findByCustomerEmail(String customerEmail);

    List<Request> findByStatus(RequestStatus status);

}