package com.codeup.springextracreditAssignment.repositories;

import com.codeup.springextracreditAssignment.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
