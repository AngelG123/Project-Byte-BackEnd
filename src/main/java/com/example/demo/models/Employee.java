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
@Table(name = "Employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Employee extends PersonalInformation{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID", updatable = false, nullable = false)
    private Long employeeID;

    @Column(name = "LastName")
    @NotNull
    private String lastName;

    @Column(name = "FirstName")
    @NotNull
    private String firstName;

    @Column(name = "Title")
    private String title;

    @Column(name = "TitleOfCourtesy")
    private String titleOfCourtesy;

    @Column(name = "BirthDate")
    private String birthDate;

    @Column(name = "HireDate")
    private String hireDate;

    @Column(name = "HomePhone")
    private String homePhone;

    @Column(name = "Extension")
    private String extension;

    @Column(name = "Photo")
    private String photo;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "ReportsTo")
    private String reportsTo;
}
