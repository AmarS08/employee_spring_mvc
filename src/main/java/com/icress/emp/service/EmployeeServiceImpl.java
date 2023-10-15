package com.icress.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icress.emp.entity.Employee;
import com.icress.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public Employee loadEmployeeForm(Long empId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(empId).get();
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long empId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(empId);
	}
}
