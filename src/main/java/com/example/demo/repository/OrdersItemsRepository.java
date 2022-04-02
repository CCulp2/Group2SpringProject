package com.example.demo.repository;

import com.example.demo.model.OrdersItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdersItemsRepository extends JpaRepository<OrdersItems, UUID> {
}
