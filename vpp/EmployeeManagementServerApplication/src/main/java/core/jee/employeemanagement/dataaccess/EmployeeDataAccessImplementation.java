package core.jee.employeemanagement.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import core.jee.employeemanagement.domain.Employee;

@Stateless
public class EmployeeDataAccessImplementation implements EmployeeDataAccess {

  public EmployeeDataAccessImplementation() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void insert(Employee newEmployee) {

  }

  @Override
  public List<Employee> findAll() {
    Employee e1 = new Employee("Jemes", "Green", "Writer", 1700);
    Employee e2 = new Employee("Sharon", "White", "Editor", 2100);
    Employee e3 = new Employee("Darren", "Blue", "Manager", 31250);
    List<Employee> employees = new ArrayList<>();
    employees.add(e1);
    employees.add(e2);
    employees.add(e3);
    return employees;
  }

  @Override
  public List<Employee> findBySurname(String name) {
    return null;
  }

}
