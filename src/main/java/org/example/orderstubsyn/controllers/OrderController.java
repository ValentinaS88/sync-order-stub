package org.example.orderstubsyn.controllers;


import org.example.orderstubsyn.models.OrderRequest;
import org.example.orderstubsyn.models.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

import static java.lang.Thread.sleep;

@RestController
@RequestMapping("/stub")
public class OrderController {

    private final Random random = new Random();

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        int delay = random.nextInt(2900) + 100;
        sleep(delay);

        if (random.nextInt(100) < 5) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(new OrderResponse(null, null, "Service unavailible"));
        }

        String orderId = UUID.randomUUID().toString();
        OrderResponse response = new OrderResponse(orderId, request.getProductName(), "CREATED");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable String id) {

        int delay = random.nextInt(500) + 50;
        sleep(delay);

        if (random.nextInt(100) < 5) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(new OrderResponse(null, null, "Order not found")
            );
        }

        if (random.nextInt(100) < 5) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body(new OrderResponse(null, null, "Server error")
            );
        }

        String status = getRandomStatus();
        String productName = getRandomProductName();
        return ResponseEntity.ok(new OrderResponse(id, productName, status));

    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }


    private String getRandomProductName() {
        String[] products = {"Book", "Newspaper", "Magazine", "Copybook", "Notepad", "Poster"};
        return products[random.nextInt(products.length)];
    }

    private String getRandomStatus() {
        String[] statuses = {"CREATED", "PROCESSING", "PAID", "SHIPPED", "COMPLETED"};
        return statuses[random.nextInt(statuses.length)];
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
