package com.example.publication.controller;

import com.example.publication.entity.Order;
import com.example.publication.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(
        @RequestParam Long bookId,
        @RequestParam Long customerId,
        @RequestParam int quantity) {
        return orderService.placeOrder(bookId, customerId, quantity);
    }
}
