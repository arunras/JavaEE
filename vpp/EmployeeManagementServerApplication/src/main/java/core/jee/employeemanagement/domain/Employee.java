package core.jee.employeemanagement.domain;

import java.io.Serializable;

public class Employee implements Serializable {
  private static final long serialVersionUID = 1L;
  private String firstName;
  private String surname;
  private String jobRole;
  private int salary;


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
