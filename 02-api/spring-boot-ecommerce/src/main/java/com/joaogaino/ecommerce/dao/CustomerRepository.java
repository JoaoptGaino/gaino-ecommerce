package com.joaogaino.ecommerce.dao;

import com.joaogaino.ecommerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
