package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;

@Component
public class EmpDao {

	private static List<Employee> list;

	static {

		list = new ArrayList<Employee>();

		list.add(new Employee(202, "Abc", "Dev", 600000));
		list.add(new Employee(101, "Xyz", "It", 45000));
		list.add(new Employee(303, "Mno", "Admin", 20000));
		list.add(new Employee(404, "Hij", "Hr", 30000));
		list.add(new Employee(505, "uvw", "Manager", 900000));

	}

	// fetching all emp's list
	public List<Employee> getAllEmps() {

		return list;

	}

	// fetching one emp data
	public Employee getById(int id) {

		for (Employee employee : list) {

			if (employee.getId() == id) {

				return employee;
			}
		}

		return null;
	}

	// creating new emp
	public Employee addNewEmp(Employee employee) {

		if (employee.getId() == 0)

			list.add(employee);

		return employee;
	}

	// deleting new emp
	public Employee deleteById(int id) {

		for (Employee employee : list) {

			if (employee.getId() == id) {

				list.remove(id);
			}
		}

		return null;
	}

}
