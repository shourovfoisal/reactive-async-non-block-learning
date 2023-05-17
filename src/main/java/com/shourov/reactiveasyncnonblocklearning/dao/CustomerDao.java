package com.shourov.reactiveasyncnonblocklearning.dao;

import com.shourov.reactiveasyncnonblocklearning.dto.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public List<Customer> loadCustomers() {
        return IntStream
                .rangeClosed(1, 10)
                .peek(System.out::println)
                .mapToObj(i -> new Customer(i, "Customer " + i))
                .toList();
    }

}
