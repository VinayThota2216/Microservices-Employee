package com.vinay.springboot.controller;

import com.vinay.springboot.model.EmployeeRequest;
import com.vinay.springboot.model.EmployeeResponse;
import com.vinay.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/saveEmployee")
    public EmployeeResponse saveEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.saveEmployee(employeeRequest);
    }

    @GetMapping("/getEmployeeById/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getEmployeeByName/{name}")
    public List<EmployeeResponse> getEmployeeByName(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }


}
