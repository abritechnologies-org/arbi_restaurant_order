package com.abri.tech.orderservice.repo;

import com.abri.tech.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantOrderRepo extends JpaRepository<Order,Long> {
}
