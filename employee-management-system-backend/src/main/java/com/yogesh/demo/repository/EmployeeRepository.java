package com.yogesh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yogesh.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
