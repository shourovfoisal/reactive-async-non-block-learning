package com.shourov.reactiveasyncnonblocklearning.dao;

import com.shourov.reactiveasyncnonblocklearning.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepForOneSec(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadCustomers() {
        return IntStream.rangeClosed(1, 10)
            .peek(CustomerDao::sleepForOneSec)
            .peek(i -> System.out.println("Count = " + i))
            .mapToObj(i -> new Customer(i, "Customer " + i))
            .toList();
    }

    public Flux<Customer> loadCustomersStream() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Count = " + i))
                .map(i -> new Customer(i, "Customer " + i));
    }
}
