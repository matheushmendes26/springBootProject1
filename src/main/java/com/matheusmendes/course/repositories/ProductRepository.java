package com.matheusmendes.course.repositories;

import com.matheusmendes.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
