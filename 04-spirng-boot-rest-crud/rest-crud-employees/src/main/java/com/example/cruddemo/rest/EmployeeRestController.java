package com.example.cruddemo.rest;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

            private EmployeeService employeeService;

            @Autowired
            public EmployeeRestController(EmployeeService theEmployeeService) {
                employeeService = theEmployeeService;
            }

            @GetMapping("/employees")
            public List<Employee> findAll() {
                return employeeService.findAll();
            }

            @GetMapping("/employees/{id}")
            public Employee findById(int id) {
                Employee theEmployee = employeeService.findById(id);

                if(theEmployee == null) {
                    throw new EmployeeNotFoundException("Student id not found: " + id);
                }
                return theEmployee;
            }

            @PostMapping("/employees")
                public Employee addEmployee(@RequestBody Employee theEmployee) {
                    theEmployee.setId(0);
                    return employeeService.save(theEmployee);
                }

            @PutMapping("/employees")
            public Employee updateEmployee(@RequestBody Employee theEmployee) {
                return employeeService.save(theEmployee);
            }

            @DeleteMapping("/employees/{id}")
            public String deleteEmployee(@PathVariable int id) {
                Employee tempEmployee = employeeService.findById(id);

                if(tempEmployee == null) {
                    throw new EmployeeNotFoundException("Employee id not found - " + id);
                }

                employeeService.deleteById(id);

                return "Deleted employee with id: " + id;
            }
}
