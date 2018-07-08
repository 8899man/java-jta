package com.test.entity;

import javax.persistence.*;

@Entity
@Table(name = "slave")
public class Slave {

    private Integer id;
    private Integer price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
