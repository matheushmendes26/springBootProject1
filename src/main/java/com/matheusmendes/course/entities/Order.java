package com.matheusmendes.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.matheusmendes.course.entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    //Implementation of attributes
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant date;

    private Integer orderStatus;

    //Implementation of associations
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(){}

    public Order(Long id, Instant date, User client, OrderStatus orderStatus) {
        this.id = id;
        this.date = date;
        this.client = client;
        setOrderStatus(orderStatus);
    }


    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }
    public void setOrderStatus(OrderStatus orderStatus){
        if(orderStatus !=null){
            this.orderStatus = orderStatus.getCode();
        }

    }

    public Set<OrderItem> getItems() {
        return items;
    }
}
