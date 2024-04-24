package com.prabhu.orderservice.service.impl;

import com.prabhu.orderservice.dto.OrderDTO;
import com.prabhu.orderservice.entity.Order;
import com.prabhu.orderservice.exception.OrderNotFoundException;
import com.prabhu.orderservice.mapper.OrderMapper;
import com.prabhu.orderservice.repository.OrderRepository;
import com.prabhu.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        log.info("Creating new order...");
        Order order = orderMapper.convertToOrder(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }

    @Override
    public Order getOrderById(Long id) throws OrderNotFoundException {
        log.info("Fetching order with id: " + id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        log.info("Fetching all orders...");
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    public Order updateOrder(Long id, OrderDTO orderDTO) throws OrderNotFoundException {
        log.info("Updating order with id: " + id);
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException("Order not found with id: " + id);
        }
        Order orderToUpdate = orderMapper.convertToOrder(orderDTO);
        orderToUpdate.setId(id);
        Order updatedOrder = orderRepository.save(orderToUpdate);
        return updatedOrder;
    }

    @Override
    public void deleteOrder(Long id) throws OrderNotFoundException {
        log.info("Deleting order with id: " + id);
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }
}
