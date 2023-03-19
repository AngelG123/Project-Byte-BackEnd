package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OrderDetails")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class OrderDetail {

    @EmbeddedId
    private OrderDetailKey id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("orderID")
    @JoinColumn(name = "OrderID")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("productID")
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "UnitPrice")
    @NotNull
    private double price;

    @Column(name = "Quantity")
    @NotNull
    private int quantity;

    @Column(name = "Discount")
    private double discount;

}
