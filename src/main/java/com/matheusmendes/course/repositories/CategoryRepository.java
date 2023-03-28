package com.matheusmendes.course.repositories;

import com.matheusmendes.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
