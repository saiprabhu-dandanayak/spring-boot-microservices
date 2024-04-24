package com.prabhu.orderservice.dto;

import com.prabhu.orderservice.entity.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String orderNumber;
    private List<OrderLineItems> orderLineItemsList;
}
