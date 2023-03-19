package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Products")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID", updatable = false, nullable = false)
    private Long productID;

    @Column(name = "ProductName")
    @NotNull
    private String productName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SupplierID")
    @NotNull
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CategoryID")
    @NotNull
    private Category category;

    @Column(name = "QuantityPerUnit")
    private int quantity;

    @Column(name = "UnitPrice")
    @NotNull
    private double price;

    @Column(name = "UnitsInStock")
    @NotNull
    private int stock;

    @Column(name = "UnitsOnOrder")
    private int unitsOrder;

    @Column(name = "ReorderLevel")
    private int reorderLevel;

    @Column(name = "Discontinued")
    private int discontinued;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails = new HashSet<>();
}
