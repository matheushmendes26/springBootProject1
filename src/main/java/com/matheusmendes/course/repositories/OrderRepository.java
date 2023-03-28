package com.matheusmendes.course.repositories;

import com.matheusmendes.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
