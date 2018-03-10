package com.virtualpairprogrammers.employeemanagement.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;

import com.virtualpairprogrammers.employeemanagement.EmployeeManagementServiceLocal;
import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@ManagedBean(name="allEmployeesPageBean")
public class AllEmployeesPageBean {
  @EJB
  private EmployeeManagementServiceLocal service;

  private UIData dataTable;
  private Employee selectedEmployee;

  public List<Employee> getAllEmployees() {
    return service.getAllEmployees();
  }

  public UIData getDataTable() {
    return this.dataTable;
  }

  public void setDataTable(UIData dataTable) {
    this.dataTable = dataTable;
  }

  public String showEmployee() {
    selectedEmployee = (Employee) dataTable.getRowData();
    return ("employeeDetail");
  }
  
  public Employee getSelectedEmployee() {
    return this.selectedEmployee;
  }
}
