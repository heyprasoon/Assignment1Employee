package com.example.assignment1employee.repositories;

import com.example.assignment1employee.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
