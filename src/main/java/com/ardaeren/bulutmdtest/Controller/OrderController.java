package com.ardaeren.bulutmdtest.Controller;

import com.ardaeren.bulutmdtest.Request.OrderRequest;
import com.ardaeren.bulutmdtest.Response.OrderResponse;
import com.ardaeren.bulutmdtest.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> addOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.addOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orderResponses = orderService.getAllOrders();
        return ResponseEntity.ok(orderResponses);
    }

    @GetMapping("/user/{appUserName}")
    public ResponseEntity<List<OrderResponse>> getAllOrdersByAppUserName(@PathVariable String appUserName) {
        List<OrderResponse> orderResponses = orderService.getAllOrdersByAppUserName(appUserName);
        return ResponseEntity.ok(orderResponses);
    }
}
