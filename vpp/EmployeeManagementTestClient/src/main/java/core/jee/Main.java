package core.jee;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import core.jee.employeemanagement.EmployeeManagementService;
import core.jee.employeemanagement.domain.Employee;


public class Main {

	public static void main(String[] args) throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
		jndiProperties.put("jboss.naming.client.ejb.context",true);
		
		Context jndi = new InitialContext(jndiProperties);
		
		EmployeeManagementService service = (EmployeeManagementService)jndi.lookup("EmployeeManagementServerApplication/EmployeeManagementImplementation!core.jee.employeemanagement.EmployeeManagementService");
		
		Employee emp1 = new Employee("Sophie","Green","Artist",1700);
		Employee emp2 = new Employee("David","Blue","Dancer",1800);
		Employee emp3 = new Employee("Ronald","Smith","Conductor",1900);
		Employee emp4 = new Employee("Eric","Jones","Pianist",2000);
		
//		service.registerEmployee(emp1);
//		service.registerEmployee(emp2);
//		service.registerEmployee(emp3);
//		service.registerEmployee(emp4);
		
		List<Employee> employees = service.searchBySurname("Smith");
		for (Employee employee: employees) {
			System.out.println(employee);
		}

	}

}
