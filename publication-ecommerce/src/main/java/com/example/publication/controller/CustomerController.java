package com.example.publication.controller;

import com.example.publication.entity.Customer;
import com.example.publication.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepo;

    @GetMapping
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    @PostMapping
    public Customer add(@RequestBody Customer customer) {
        return customerRepo.save(customer);
    }

    @GetMapping("/zip/{zipCode}")
    public List<Customer> getByZip(@PathVariable String zipCode) {
        return customerRepo.findByZipCode(zipCode);
    }
}
