package com.icress.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.icress.emp.entity.Employee;
import com.icress.emp.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public String EmployeeDashboard(Model model) {
		List<Employee> employeeList = employeeService.getAllEmployee();
		model.addAttribute("employees", employeeList);
		return "show_employees";
	}

	@GetMapping("/create_employee_form")
	public String loadCreateEmployeeform(Model model) {
		model.addAttribute("employee", new Employee());
		return "create_employee";
	}

	@PostMapping("/create_employee")
	public String createEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		employeeService.createEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/update_employee_form")
	public String loadEditEmployee(@RequestParam Long empId, Model model) {
		Employee employee = employeeService.loadEmployeeForm(empId);
		model.addAttribute("employee", employee);
		return "update_employee_form";
	}

	@PostMapping("/update_employee")
	public String updateRecipes(@ModelAttribute("employee") Employee employee, Model model) {
		employeeService.updateEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/delete_employee")
	public String deleteRecipes(@RequestParam Long empId, Model model) {
		employeeService.deleteEmployee(empId);
		return "redirect:/employees";
	}
}
