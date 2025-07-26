package com.example.publication.repository;

import com.example.publication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByZipCode(String zipCode);
}
