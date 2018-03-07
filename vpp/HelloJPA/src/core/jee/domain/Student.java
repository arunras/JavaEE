package core.jee.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Represents a Student enrolled in the college management
 * system (CMS)
 */
@Entity
public class Student
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
    private String enrollmentID;
    private String name;

    @ManyToOne
    @JoinColumn(name="TUTOR_FK")
    private Tutor supervisor;
    
    @Embedded
    private Address address;

    /*
     * Required by Hibernate
     */
    public Student()
    {
    	
    }
    

    /**
     * Initialises a student with no pre set tutor
     */
    public Student(String name, String enrollmentID, String street, String city, String zip) {
    		this.name = name;
    		this.enrollmentID = enrollmentID;
    		this.supervisor = null;
    		this.address = new Address(street, city, zip);
    }
    
    public Student(String name, String enrollmentID) {
    		this.name = name;
    		this.enrollmentID = enrollmentID;
    		this.address = null;
    }
    
    public double calculateGradePointAverage()
    {
    	// some complex business logic!
    	// we won't need this method on the course, BUT it is import
    	// to remember that classes aren't just get/set pairs - we expect
    	// business logic in here as well.
    	return 0;
    }
  
    public void allocateSupervisor(Tutor newSupervisor) {
      this.supervisor = newSupervisor;
      newSupervisor.getModifiableVisionGroup().add(this);
    }

    public String getSupervisorName() {
      return this.supervisor.getName();
    }
    public Tutor getSupervisor() {
      return this.supervisor;
    }


    public String toString()
    {
    	return this.name + " lives at: " + this.address;
    }
    
    public int getId()
    {
    	return this.id;
    }

		public String getEnrollmentId() {
			return this.enrollmentID;
		}
}
