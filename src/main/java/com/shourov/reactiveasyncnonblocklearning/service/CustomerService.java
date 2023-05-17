package com.shourov.reactiveasyncnonblocklearning.service;

import com.shourov.reactiveasyncnonblocklearning.dao.CustomerDao;
import com.shourov.reactiveasyncnonblocklearning.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao dao;

    public List<Customer> getAllCustomers() {
        long startTime = System.currentTimeMillis();
        List<Customer> customers = dao.loadCustomers();
        long endTime = System.currentTimeMillis();

        System.out.println("Execution time (Standard Programming): " + (endTime-startTime));
        return customers;
    }

}
