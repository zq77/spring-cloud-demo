package com.z.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderDetail extends Mixin {
    @Id
    @GeneratedValue
    private Long id;

    private Order order;
    // TODO
}
