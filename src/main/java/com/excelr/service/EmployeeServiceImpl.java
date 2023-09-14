package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.excelr.entity.Employee;
import com.excelr.exception.IdnotFoundException;
import com.excelr.repository.EmployeeRepository;
import com.excelr.utility.AppConstant;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getallEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public String deletEmployee(int id) {
		
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
		}else {
			throw new IdnotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
		}
		
		return "delete succesfull";
	}

	@Override
	public String updateEmployee(int id, Employee employee) {
	
		
		if(employeeRepository.existsById(id)) {
			Employee employee2= employeeRepository.findById(id).get();
			employee2.setName(employee.getName());
			employee2.setDepartment(employee.getDepartment());
			employee2.setSalary(employee.getSalary());
			
			employeeRepository.save(employee2);
			
		}else {
			throw new IdnotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
		}
		
		return "successful";
	}

}
