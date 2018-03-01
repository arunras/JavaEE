package core.jee.employeemanagement.dataaccess;

import java.util.List;

import javax.ejb.Local;

import core.jee.employeemanagement.domain.Employee;

@Local
public interface EmployeeDataAccess {
  public void insert(Employee newEmployee);
  public List<Employee> findAll();
  public List<Employee> findBySurname(String name);
}
