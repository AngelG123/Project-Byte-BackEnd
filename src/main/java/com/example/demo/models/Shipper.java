package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Shippers")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Shipper {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipperID", updatable = false, nullable = false)
    private Long shipperID;

    @Column(name = "CompanyName")
    @NotNull
    private String companyName;

    @Column(name = "Phone", length = 9)
    @Pattern(regexp = "[0-9]{9}")
    private String phone;

}
