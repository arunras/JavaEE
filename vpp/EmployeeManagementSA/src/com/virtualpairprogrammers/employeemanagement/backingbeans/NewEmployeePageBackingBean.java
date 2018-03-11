package com.virtualpairprogrammers.employeemanagement.backingbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.virtualpairprogrammers.employeemanagement.EmployeeManagementServiceLocal;
import com.virtualpairprogrammers.employeemanagement.ServiceUnavailableException;
import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@ManagedBean(name="newEmployee")
public class NewEmployeePageBackingBean {
  private String firstName;
  private String surname;
  private String jobRole;

  @Min(value=1, message="Salary must be greater than or equal to 1")
  @Max(value=100_000, message="Salary must be less than 100,000")
  private int salary;

  @EJB
  private EmployeeManagementServiceLocal service;


  public String createEmployee() {
    Employee employee = new Employee(firstName, surname, jobRole, salary);
    try {
    		service.registerEmployee(employee);
    		return "employeeDetail2?employeeId=" + employee.getId() + "&faces-redirect=true";
    } catch(ServiceUnavailableException e) {
      return "employeeNotCreated";
    }



  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setSurname(String surname) {
    this.surname= surname;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setJobRole(String jobRole) {
    this.jobRole = jobRole;
  }

  public String getJobRole() {
    return this.jobRole;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getSalary() {
    return this.salary;
  }

}
