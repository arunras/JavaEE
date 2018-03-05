package core.jee.testharness;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import core.jee.domain.Student;

public class HibernateTestHarness 
{
	private static SessionFactory sessionFactory = null;

	public static void main(String[] args)
	{
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

	  //Do something
    Student student = new Student("Kathleen Heddle");
    session.save(student);
    
		
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
