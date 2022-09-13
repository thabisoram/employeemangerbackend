package tech.rams.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable =false, updatable =false)
	private Long id;
	private String name;
	private String email;
	private String jobTitle;
	private String phone;
	private String image;
	@Column(nullable =false, updatable =false)
	private String employeeCode;
	 
	public Employee() {
		
	}

	public Employee(String name, String email, String jobTitle, String phone, String image, String employeeCode) {
		super();
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.image = image;
		this.employeeCode = employeeCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	@Override
	public String toString()
	{
		return "Employee{" +
				"id='" + id +
				", name='" + name +'\''+
				", email='" + email +'\''+
				", jobTitle='" + jobTitle +'\''+
				", phone='" + phone +'\''+
				", imageUrl='" + image+'\''+
				"}";
	}
}
