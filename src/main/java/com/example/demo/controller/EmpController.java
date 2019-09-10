package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
import com.example.demo.entity.Employee;

@RestController
@RequestMapping("/empdata")
public class EmpController {

	@Autowired
	EmpDao dao;

	@GetMapping("/one/{id}")
	public Employee getOne(@PathVariable int id) {

		Employee employee = dao.getById(id);

		if (employee.getId() != id) {

			throw new NoEmpFoundExcep("No emp details found");

		}

		Resource<Employee> resource = new Resource<Employee>(employee);
		
		

		// ResponseEntity<Employee> entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		// return dao.getById(id);
		return employee;
	}

	@GetMapping("/all")
	public List<Employee> getAll() {

		return dao.getAllEmps();
	}

	@PostMapping("/create")
	public Employee createEmp(@RequestBody Employee employee) {

		return dao.addNewEmp(employee);

	}

	@DeleteMapping("/onedelete/{id}")
	public void deleteOne(@PathVariable int id) {

		dao.deleteById(id);
	}

}
