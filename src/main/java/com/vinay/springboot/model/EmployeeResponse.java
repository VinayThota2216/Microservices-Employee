package com.vinay.springboot.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class EmployeeResponse {

    private Long id;
    private String name;
    private String dob;
    private double salary;
    private String dept;
    private String email;
}
