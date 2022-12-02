package com.org.customer.dao;

import com.org.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class is responsible for persisting customer
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
