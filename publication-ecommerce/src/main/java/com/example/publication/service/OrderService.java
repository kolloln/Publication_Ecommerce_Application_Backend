package com.example.publication.service;

import com.example.publication.entity.*;
import com.example.publication.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepo;
    private final BookRepository bookRepo;
    private final CustomerRepository customerRepo;

    public Order placeOrder(Long bookId, Long customerId, int quantity) {
        Book book = bookRepo.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book not found"));
        Customer customer = customerRepo.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (book.getStock() < quantity)
            throw new RuntimeException("Not enough stock");

        book.setStock(book.getStock() - quantity);
        bookRepo.save(book);

        Order order = Order.builder()
            .book(book)
            .customer(customer)
            .quantity(quantity)
            .orderDate(LocalDateTime.now())
            .build();

        return orderRepo.save(order);
    }
}
