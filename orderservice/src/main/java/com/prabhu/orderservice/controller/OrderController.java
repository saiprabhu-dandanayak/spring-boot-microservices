package com.prabhu.orderservice.controller;

import com.prabhu.orderservice.dto.OrderDTO;
import com.prabhu.orderservice.entity.Order;
import com.prabhu.orderservice.exception.OrderNotFoundException;
import com.prabhu.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        log.info("Creating new order...");
        Order createdOrder = orderService.createOrder(orderDTO);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) throws OrderNotFoundException {
        log.info("Fetching order with id: {}", id);
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        log.info("Fetching all orders...");
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id, @Valid @RequestBody OrderDTO orderDTO)
            throws OrderNotFoundException {
        log.info("Updating order with id: {}", id);
        Order updatedOrder = orderService.updateOrder(id, orderDTO);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) throws OrderNotFoundException {
        log.info("Deleting order with id: {}", id);
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
