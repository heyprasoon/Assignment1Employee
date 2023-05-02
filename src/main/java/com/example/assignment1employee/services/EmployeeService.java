package com.example.assignment1employee.services;


import com.example.assignment1employee.entities.Employee;
import com.example.assignment1employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

        @Autowired
        EmployeeRepository employeeRepository;

        public void addemp(List<Employee> list)
        {
            employeeRepository.saveAll(list);
        }

        public List<Employee> getemps(){

            return (List<Employee>) employeeRepository.findAll();
        }

        public ResponseEntity<Employee> getemp(int id){
            Optional<Employee>  optionalEmployee= employeeRepository.findById(id);
            if(optionalEmployee.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

              return  ResponseEntity.of(optionalEmployee);

        }

        public void deleteemp(int id){
            employeeRepository.deleteById(id);
        }




}
