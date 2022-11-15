package com.alura.mvc.mudi.repository;

import com.alura.mvc.mudi.model.Order;
import com.alura.mvc.mudi.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAll();

    List<Order> findByStatus(OrderStatus status);
}
