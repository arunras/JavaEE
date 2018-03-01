package core.jee.employeemanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import core.jee.employeemanagement.dataaccess.EmployeeDataAccess;
import core.jee.employeemanagement.domain.Employee;

@Stateless
public class EmployeeManagementImplementation implements EmployeeManagementService {
  @Inject
  private EmployeeDataAccess dao;

  @Override
  public void registerEmployee(Employee employee) {
    dao.insert(employee);
  }

  @Override
  public List<Employee> getAllEmployees() {
    return dao.findAll();
  }

  @Override
  public List<Employee> searchBySurname(String surname) {
    return dao.findBySurname(surname);
  }
}
