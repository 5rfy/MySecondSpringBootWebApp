package com.example.springbootdatajpa.Controllers;



import com.example.springbootdatajpa.Entity.Employee;
import com.example.springbootdatajpa.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {

        List<Employee> employeeList = employeeService.getAllEmployees();

        return employeeList;
    }
    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        return employee;
    }
    @PostMapping("/employees")
    public Employee addNewEmployees(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployee(id);

        return "Employee with ID = " + id + " was deleted";
    }
    @GetMapping("/employees/name/{name}")
    public List<Employee> findAllByName(@PathVariable String name) {

        return employeeService.findAllByName(name);
    }
}
