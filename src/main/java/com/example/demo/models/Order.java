package com.example.demo.models;

import java.util.Date;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID", updatable = false, nullable = false)
    private Long orderID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CustomerID")
    @NotNull
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EmployeeID")
    @NotNull
    private Employee employee;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OrderDate")
    @NotNull
    private Date orderDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RequiredDate")
    @NotNull
    private Date requiredDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ShippedDate")
    @NotNull
    private Date shippedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ShipVia")
    @NotNull
    private Shipper shipper;

    @Column(name = "Freight")
    private String freight;

    @Column(name = "ShipName")
    private String shipName;

    @Column(name = "ShipAddress")
    private String shipAddress;

    @Column(name = "ShipCity")
    private String shipCity;

    @Column(name = "ShipRegion")
    private String shipRegion;

    @Column(name = "ShipPostalCode")
    private String shipPostalCode;

    @Column(name = "ShipCountry")
    private String shipCountry;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails = new HashSet<>();

}
