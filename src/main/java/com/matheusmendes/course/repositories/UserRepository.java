package com.matheusmendes.course.repositories;

import com.matheusmendes.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
