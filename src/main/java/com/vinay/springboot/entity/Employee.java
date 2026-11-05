package com.vinay.springboot.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employeeData")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dob;
    private double salary;
    private String dept;
    private String email;


}
