package com.joaogaino.ecommerce.dto;

import com.joaogaino.ecommerce.entities.Address;
import com.joaogaino.ecommerce.entities.Customer;
import com.joaogaino.ecommerce.entities.Order;
import com.joaogaino.ecommerce.entities.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class PurchaseDTO {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
