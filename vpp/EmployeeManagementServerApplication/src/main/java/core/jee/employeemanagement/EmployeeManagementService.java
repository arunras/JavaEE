package core.jee.employeemanagement;

import java.util.List;

import core.jee.employeemanagement.domain.Employee;

@Remote
public interface EmployeeManagementService {
  public void registerEmployee(Employee employee);
  public List<Employee> getAllEmployees();
  public List<Employee> searchBySurname(String surname);
}
