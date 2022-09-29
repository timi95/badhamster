package com.rodent.badhamster.repository;

import com.rodent.badhamster.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
}
