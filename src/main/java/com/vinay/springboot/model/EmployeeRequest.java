package com.vinay.springboot.model;

import lombok.Data;

@Data
public class EmployeeRequest {

    private String name;
    private String dob;
    private double salary;
    private String dept;
    private String email;

}
