package com.prabhu.orderservice.mapper;

import com.prabhu.orderservice.dto.OrderDTO;
import com.prabhu.orderservice.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderMapper {

    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO convertToOrderDTO(Order order) {
        try {
            log.info(">>> INSIDE OrderMapper: convertToOrderDTO() Converting entity to DTO");
            return modelMapper.map(order, OrderDTO.class);
        } catch (NullPointerException exception) {
            log.error(">>> INSIDE OrderMapper: convertToOrderDTO() Converting entity to DTO");
            throw new NullPointerException("NullPointerException in converting to DTO");
        }
    }

    public Order convertToOrder(OrderDTO orderDTO) {
        try {
            log.info(">>> INSIDE OrderMapper: convertToOrder() Converting DTO to entity");
            return modelMapper.map(orderDTO, Order.class);
        } catch (NullPointerException exception) {
            log.error(">>> INSIDE OrderMapper: convertToOrder() Converting DTO to entity");
            throw new NullPointerException("NullPointerException in converting to entity");
        }
    }
}
