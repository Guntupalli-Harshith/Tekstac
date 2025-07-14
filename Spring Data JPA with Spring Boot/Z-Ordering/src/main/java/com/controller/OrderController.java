package com.controller;

import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place/{productId}/{quantity}")
    public ResponseEntity<String> placeOrder(@PathVariable Long productId, @PathVariable int quantity) {
    try {
        String result = orderService.placeOrder(productId, quantity);
        return new ResponseEntity<>(result, HttpStatus.OK); // Always return 200
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK); // also return 200
            }
    }
}