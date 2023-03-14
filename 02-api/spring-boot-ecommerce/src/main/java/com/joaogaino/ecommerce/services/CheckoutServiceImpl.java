package com.joaogaino.ecommerce.services;

import com.joaogaino.ecommerce.dao.CustomerRepository;
import com.joaogaino.ecommerce.dto.PurchaseDTO;
import com.joaogaino.ecommerce.dto.PurchaseResponseDTO;
import com.joaogaino.ecommerce.entities.Customer;
import com.joaogaino.ecommerce.entities.Order;
import com.joaogaino.ecommerce.entities.OrderItem;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public PurchaseResponseDTO placeOrder(PurchaseDTO purchase) {
        //retrieve the order from dto
        Order order = purchase.getOrder();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(order::add);

        //populate order with addresses
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        //return response
        return new PurchaseResponseDTO(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //generate random uuid
        return UUID.randomUUID().toString();
    }
}
