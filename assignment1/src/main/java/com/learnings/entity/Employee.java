package com.learnings.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	private LocalDateTime createdDateTime;
	private String createdByUsername;
	private LocalDateTime updatedDateTime;
	private String updatedByUsername;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public String getCreatedByUsername() {
		return createdByUsername;
	}
	public void setCreatedByUsername(String createdByUsername) {
		this.createdByUsername = createdByUsername;
	}
	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	public String getUpdatedByUsername() {
		return updatedByUsername;
	}
	public void setUpdatedByUsername(String updatedByUsername) {
		this.updatedByUsername = updatedByUsername;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + ", createdDateTime=" + createdDateTime + ", createdByUsername=" + createdByUsername
				+ ", updatedDateTime=" + updatedDateTime + ", updatedByUsername=" + updatedByUsername + "]";
	}
	public Employee(Long id, String firstName, String lastName, Department department, LocalDateTime createdDateTime,
			String createdByUsername, LocalDateTime updatedDateTime, String updatedByUsername) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.createdDateTime = createdDateTime;
		this.createdByUsername = createdByUsername;
		this.updatedDateTime = updatedDateTime;
		this.updatedByUsername = updatedByUsername;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	 @PrePersist
	    protected void onCreate() {
	        createdDateTime = LocalDateTime.now();
	        updatedDateTime = LocalDateTime.now();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        updatedDateTime = LocalDateTime.now();
	    }
	
	

}
