package core.jee.employeemanagement.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import core.jee.employeemanagement.domain.Employee;

@Stateless
@Default
@ProductionDao
public class EmployeeDataAccessProductionVersion implements EmployeeDataAccess {
  @PersistenceContext
  private EntityManager em;

  public EmployeeDataAccessProductionVersion() {
  }

  @Override
  public void insert(Employee newEmployee) {
    em.persist(newEmployee);
  }

  @Override
  public List<Employee> findAll() {
    Query q = em.createQuery("SELECT employee FROM Employee employee");
    List<Employee> employees = q.getResultList();
    return employees;
  }

  @Override
  public List<Employee> findBySurname(String surname) {
    Query q = em.createQuery("SELECT employee FROM Employee employee WHERE employee.surname = :surname");
    q.setParameter("surname", surname);
    return q.getResultList();
  }

}
