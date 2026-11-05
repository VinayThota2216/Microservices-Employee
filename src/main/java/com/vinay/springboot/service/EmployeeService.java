package com.vinay.springboot.service;


import com.vinay.springboot.entity.Employee;
import com.vinay.springboot.model.EmployeeRequest;
import com.vinay.springboot.model.EmployeeResponse;
import com.vinay.springboot.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeRequestToEntity(employeeRequest);

        return employeeEntityToResponse(employeeRepository.save(employee));
    }

    // Convert Employee Request to Entity
    public Employee employeeRequestToEntity(EmployeeRequest request) {

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setDept(request.getDept());
        employee.setSalary(request.getSalary());
        employee.setDob(request.getDob());
        employee.setEmail(request.getEmail());

        return employee;
    }

    // Convert Employee Entity to Response
    public EmployeeResponse employeeEntityToResponse(Employee entity) {

        EmployeeResponse response = new EmployeeResponse();

        response.setId(entity.getId());
        response.setDept(entity.getDept());
        response.setName(entity.getName());
        response.setDob(entity.getDob());
        response.setSalary(entity.getSalary());
        response.setEmail(entity.getEmail());

        return response;
    }

    // GetEmployeeByID
    public EmployeeResponse getEmployeeById(Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        return employee.map(this::employeeEntityToResponse).orElse(null);
    }

    // Get Employee By Name
    public List<EmployeeResponse> getEmployeeByName(String name) {

        return listOfEmployeeEntityToResponse(employeeRepository.findByName(name));
    }

    // Convert List of Employee Entity to Response
    public List<EmployeeResponse> listOfEmployeeEntityToResponse(
            List<Employee> employees) {

        return employees.stream()
                .map(this::employeeEntityToResponse)
                .toList();
    }

//    // Delete Employee By ID
//    public String deleteEmployeeById(Long id) {
//
//        Optional<Employee> employee = employeeRepository.findById(id);
//
//        if (employee.isPresent()) {
//            employeeRepository.deleteById(id);
//            return "Employee with " + id + " is deleted";
//        }
//
//        return "Employee record not found to delete";
//    }
//

//
//
//

}