package com.example.assignment1employee.controllers;


import com.example.assignment1employee.entities.Employee;
import com.example.assignment1employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {

        @Autowired
        EmployeeService employeeService;

        @GetMapping("/getemps")
        public List<Employee> getemps(){
                return employeeService.getemps();
        }


        @GetMapping("/getemp/{id}")
        public Employee getemp(@PathVariable("id") int id){
                return  employeeService.getemp(id);
        }

        @PostMapping("/addemp")
        public void addemp(@RequestBody List<Employee> list)
        {
                employeeService.addemp(list);
        }

        @PutMapping("/updateemp/{id}")
        public ResponseEntity<String> updateemp(@RequestBody Employee emp, @PathVariable("id") int empid){

               return employeeService.updateemp(emp, empid);

        }

        @DeleteMapping("/deleteemp/{id}")
        public ResponseEntity<String> deleteemp(@PathVariable("id") int id)
        {
                employeeService.deleteemp(id);
                return new ResponseEntity<>("Deleted Successfully by seb", HttpStatus.OK);
        }

}
