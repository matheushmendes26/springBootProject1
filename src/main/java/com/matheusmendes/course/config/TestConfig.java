package com.matheusmendes.course.config;

import com.matheusmendes.course.entities.Category;
import com.matheusmendes.course.entities.Order;
import com.matheusmendes.course.entities.User;
import com.matheusmendes.course.entities.enums.OrderStatus;
import com.matheusmendes.course.repositories.CategoryRepository;
import com.matheusmendes.course.repositories.OrderRepository;
import com.matheusmendes.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null,"Electronics");
        Category c2 = new Category(null,"Beauty");
        Category c3 = new Category(null,"Food");
        Category c4 = new Category(null,"Domestic");

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2,OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1,OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
    }
}
