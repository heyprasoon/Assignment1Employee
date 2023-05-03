package com.example.assignment1employee.services;


import com.example.assignment1employee.entities.Employee;
import com.example.assignment1employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

        public Employee getemp(int id){
            return employeeRepository.findById(id).get();
//            if(optionalEmployee.isEmpty()){
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//
//              return  ResponseEntity.of(optionalEmployee);

        }

        public ResponseEntity<String> updateemp(Employee emp, int empid)
        {
                if(emp.getId()!=empid)
                        return  new ResponseEntity<>("Invalid Input",HttpStatus.BAD_REQUEST);
                Optional<Employee> employeeOptional = employeeRepository.findById(empid);
                if(employeeOptional.isEmpty()) {
//                        return new ResponseEntity<>("No such ID exists", HttpStatus.NOT_FOUND);
                        List<Employee> list = new ArrayList<>();
                        list.add(emp);
                        addemp(list);
                }
                else {
                        Employee tempemp = employeeOptional.get();
                        tempemp.setCity(emp.getCity());
                        employeeRepository.save(tempemp);
                }
                return new ResponseEntity<>("SucessFully Updated", HttpStatus.OK);
        }

        public void deleteemp(int id){
            employeeRepository.deleteById(id);
        }




}
