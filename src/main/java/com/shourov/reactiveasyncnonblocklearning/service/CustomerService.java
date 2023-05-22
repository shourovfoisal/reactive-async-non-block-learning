package com.shourov.reactiveasyncnonblocklearning.service;

import com.shourov.reactiveasyncnonblocklearning.dao.CustomerDao;
import com.shourov.reactiveasyncnonblocklearning.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao dao;

    // Synchronous and blocking
    public List<Customer> getAllCustomers() {
        long startTime = System.currentTimeMillis();
        List<Customer> customers = dao.loadCustomers();
        long endTime = System.currentTimeMillis();

        System.out.println("Execution time (Standard Programming): " + (endTime-startTime));
        return customers;
    }

    // Asynchronous and non-blocking
    public Flux<Customer> getAllCustomersStream() {
        long startTime = System.currentTimeMillis();
        Flux<Customer> customers = dao.loadCustomersStream();
        long endTime = System.currentTimeMillis();

        System.out.println("Execution time (Reactive Programming): " + (endTime-startTime));
        return customers;
    }
}
