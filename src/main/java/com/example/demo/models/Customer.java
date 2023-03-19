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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Customer extends PersonalInformation{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID", updatable = false, nullable = false)
    private Long customerID;

    @Column(name = "CompanyName")
    @NotBlank(message="Campo nombre de empresa es requerido")
    private String companyName;

    @Column(name = "ContactName")
    @NotBlank(message="Campo nombre del contacto es requerido")
    private String contactName;

    @Column(name = "ContactTitle")
    @NotBlank(message="Campo titulo de contacto es requerido")
    private String contactTitle;

    @Column(name = "Phone", length = 9)
    @NotBlank(message="Campo telefono es requerido")
    @Pattern(regexp = "[0-9]{9}", message="Numero de telefono invalido")
    private String phone;

    @Column(name = "Fax")
    @NotBlank(message="Campo fax es requerido")
    private String fax;

}
