package core.jee.employeemanagement;

import java.util.ArrayList;
import java.util.List;

import core.jee.employeemanagement.domain.Employee;

@Stateless
public class EmployeeManagementImplementation implements EmployeeManagementService {

  public void registerEmployee(Employee employee) {

  }

  public List<Employee> getAllEmployees() {
    Employee e1 = new Employee("Jemes", "Green", "Writer", 1700);
    Employee e2 = new Employee("Sharon", "White", "Editor", 2100);
    List<Employee> employees = new ArrayList<>();
    employees.add(e1);
    employees.add(e2);
    return employees;
  }

  public List<Employee> searchBySurname(String surname) {
    return null;
  }
}
