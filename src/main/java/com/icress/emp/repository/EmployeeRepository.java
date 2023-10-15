package com.icress.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icress.emp.entity.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Long>{

}
