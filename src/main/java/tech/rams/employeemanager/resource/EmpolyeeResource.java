package tech.rams.employeemanager.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.rams.employeemanager.model.Employee;
import tech.rams.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmpolyeeResource {
	
	EmployeeService employeeService;
	
	public EmpolyeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity <Employee> addEmployee(@RequestBody Employee employee){
		Employee newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity <Employee> updateEmployee(@RequestBody Employee employee){
		Employee newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	@Transactional
	public ResponseEntity <?> DeleteEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
