package com.matheusmendes.course.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    //Implementation of attributes
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant date;
    //Implementation of associations
    @ManyToOne
    private User client;

    public Order(){}

    public Order(Long id, Instant date, User client) {
        this.id = id;
        this.date = date;
        this.client = client;
    }


}
