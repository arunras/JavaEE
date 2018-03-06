package core.jee.testharness;

import java.util.List;

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
    

    /*
    Tutor newTutor = new Tutor("ABC844", "Adrian Nattan", 387683);

    Student s1 = new Student("Rebecca Soni", "1-SON-2012");
    Student s2 = new Student("Zou Kai", "2-KAI-2009");
    Student s3 = new Student("Chris Hoy", "3-HOY-1997");

    session.save(s1);
    session.save(s2);
    session.save(s3);
    session.save(newTutor);
    
    newTutor.addStudentToSupervisionGroup(s1);       
    newTutor.addStudentToSupervisionGroup(s2);
    newTutor.addStudentToSupervisionGroup(s3);
    */

    Tutor myTutor = (Tutor) session.get(Tutor.class, 1);
    List<Student> students = myTutor.getSupervisionGroup();
    for (Student next : students) {
      System.out.println(next);
    }


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
