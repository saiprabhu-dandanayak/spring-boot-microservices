package com.prabhu.orderservice.service;

import com.prabhu.orderservice.dto.OrderDTO;
import com.prabhu.orderservice.entity.Order;
import com.prabhu.orderservice.exception.OrderNotFoundException;

import java.util.List;

public interface OrderService {

    Order createOrder(OrderDTO orderDTO);

    Order getOrderById(Long id) throws OrderNotFoundException;

    List<Order> getAllOrders();

    Order updateOrder(Long id, OrderDTO orderDTO) throws OrderNotFoundException;

    void deleteOrder(Long id) throws OrderNotFoundException;
}
