package com.icress.emp.service;

import java.util.List;

import com.icress.emp.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployee();

	public void createEmployee(Employee employee);

	public Employee loadEmployeeForm(Long empId);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(Long empId);
}
