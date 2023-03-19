package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public class PersonalInformation {
    
    @Column(name = "Address")
    @NotBlank(message="Campo direccion es requerido")
    private String address;

    @Column(name = "City")
    @NotBlank(message="Campo ciudad es requerido")
    private String city;

    @Column(name = "Region")
    @NotBlank(message="Campo region es requerido")
    private String region;

    @Column(name = "PostalCode")
    @NotBlank(message="Campo codigo postal es requerido")
    @Pattern(regexp = "[0-9]*", message="Codigo postal invalido")
    private String postalCode;

    @Column(name = "Country")
    @NotBlank(message="Campo pais es requerido")
    private String country;
    
}
