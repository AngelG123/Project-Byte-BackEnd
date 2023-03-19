package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;

public class OrderDetailKey implements Serializable{
    
    @Column(name = "OrderID")
    private Long orderID;

    @Column(name = "ProductID")
    private Long productID;
    
}
