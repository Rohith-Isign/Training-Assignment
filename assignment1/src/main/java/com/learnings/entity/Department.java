package com.learnings.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private LocalDateTime createdDateTime;
	private String createdByUsername;
	private LocalDateTime updatedDateTime;
	private String updatedByUsername;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employees;

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", createdDateTime=" + createdDateTime
				+ ", createdByUsername=" + createdByUsername + ", updatedDateTime=" + updatedDateTime
				+ ", updatedByUsername=" + updatedByUsername + ", employees=" + employees + "]";
	}

	public Department(Long id, String name, LocalDateTime createdDateTime, String createdByUsername,
			LocalDateTime updatedDateTime, String updatedByUsername, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.createdDateTime = createdDateTime;
		this.createdByUsername = createdByUsername;
		this.updatedDateTime = updatedDateTime;
		this.updatedByUsername = updatedByUsername;
		this.employees = employees;
	}

	public Department() {
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
