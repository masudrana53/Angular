package com.employee.rest_api.api_controller;
import com.employee.rest_api.model.Employee;
import com.employee.rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class ApiController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> allEmployee(){
        return employeeRepository.findAll();
    }


    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }


    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean exist=employeeRepository.existsById(id);
        if(exist){
            employeeRepository.deleteById(id);
            return new ResponseEntity<>("Employee is deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee is not exist", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> update(@PathVariable("ID") int id, @RequestBody Employee employee){
        boolean exist=employeeRepository.existsById(id);

        if (exist) {
            Employee employee1=employeeRepository.findById(id).get();
            employee1.setName(employee.getName());
            employee1.setId(id);
            employeeRepository.save(employee);
            return new ResponseEntity<>("Employee is Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee is not Exist", HttpStatus.BAD_REQUEST);
    }
}
