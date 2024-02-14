package com.yogesh.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogesh.demo.model.Employee;
import com.yogesh.demo.repository.EmployeeRepository;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employee")
	public List<Employee> getUsers(){
		
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getUsersById(@PathVariable Long id){
		
		return employeeRepository.findById(id);
	}
	
	
	
	//create 
	@PostMapping("/employee")
	public Employee createUser(@RequestBody Employee employee) {
		System.out.println("user created");
		return employeeRepository.save(employee);
	}
	
	
	
	 // Update
    @PutMapping("/employee/{id}")
    public Employee updateUser(@PathVariable Long id, @RequestBody Employee updatedemployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
        
        	Employee employee = optionalEmployee.get();
        
        	employee.setFirstname(updatedemployee.getFirstname());
        	employee.setLastname(updatedemployee.getLastname());
        	employee.setEmail(updatedemployee.getEmail());
       
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
	
	@DeleteMapping("/employee/{id}")
	public String deleteUser(@PathVariable Long id) {
		employeeRepository.deleteById(id);
		return "employee is deleted with id :- "+id;
	}
}
