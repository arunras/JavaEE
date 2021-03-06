package core.jee.employeemanagement.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
  private static final long serialVersionUID = 1L;
  private String firstName;
  private String surname;
  private String jobRole;
  private int salary;

  public Employee() {
    // required by JPA 
  }


	public Employee(String firstName, String surName, String jobRole, int salary) {
		super();
		this.firstName = firstName;
		this.surname = surName;
		this.jobRole = jobRole;
		this.salary = salary;
	}

  @Override
  public String toString() {
    return "Employee : " + this.firstName + " " + this.surname;
  }

}
