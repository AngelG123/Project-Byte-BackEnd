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
@Table(name = "Suppliers")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Supplier extends PersonalInformation{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID", updatable = false, nullable = false)
    private Long supplierID;

    @Column(name = "CompanyName")
    @NotNull
    private String companyName;

    @Column(name = "ContactName")
    @NotNull
    private String contactName;

    @Column(name = "ContactTitle")
    private String contactTitle;

    @Column(name = "Phone", length = 9)
    @Pattern(regexp = "[0-9]{9}")
    private String phone;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "HomePage")
    private String homePage;

}
