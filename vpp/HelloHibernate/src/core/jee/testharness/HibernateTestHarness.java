package core.jee.testharness;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import core.jee.domain.Student;
import core.jee.domain.Tutor;

public class HibernateTestHarness 
{
	private static SessionFactory sessionFactory = null;

	public static void main(String[] args)
	{
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

    /*
	  // create a new supervisor, and a student
    Student student = new Student("Alicia Coutts");
    Tutor newTutor = new Tutor("DEF456", "Michael Jung", 939383);
    
    // make the student be supervised by that tutor
    student.allocateSupervisor(newTutor);

    // print out the supervisor for this tutor
    System.out.println(student.getSupervisorName());

    session.save(student);
    session.save(newTutor);
    */

    Student student = (Student) session.get(Student.class, 1);
    System.out.println(student);

    student.allocateSupervisor(null);

		tx.commit();
		session.close();
	}

	public static SessionFactory getSessionFactory()
	{
		if (sessionFactory == null)
		{
			Configuration configuration = new Configuration();
			configuration.configure();
			
			ServiceRegistry serviceRegistry = new 
					ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();        

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}			
}
