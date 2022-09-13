package tech.rams.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.rams.employeemanager.exception.UserNotFoundException;
import tech.rams.employeemanager.model.Employee;
import tech.rams.employeemanager.repository.EmployeeRepo;

@Service
public class EmployeeService {

	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
			.orElseThrow(() -> new UserNotFoundException("User by ID: "+id+" not found"));
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
}
