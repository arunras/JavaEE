package core.jee.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Tutor {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String staffId;
  private String name;
  private int salary;

  @OneToMany(mappedBy="supervisor", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
  //@OrderColumn(name="student_order")
  //@MapKey(name="enrollmentID")
  //@JoinColumn(name="TUTOR_FK")
  private Set<Student> supervisionGroup;

  @ManyToMany(mappedBy="qualifiedTutors")
  private Set<Subject> subjectsQualifiedToTeach;


  public Tutor() {/*Required by Hiberante*/}

  // "Business constructor"
  public Tutor(String staffId, String name, int salary) {
    super();
    this.staffId = staffId;
    this.name = name;
    this.salary = salary;
    this.supervisionGroup = new HashSet<>();
    this.subjectsQualifiedToTeach = new HashSet<>();
  }

  public void addSubjectToQualifications(Subject subject) {
    this.subjectsQualifiedToTeach.add(subject);
    subject.getQualifiedTutors().add(this);
  }

  public void addStudentToSupervisionGroup(Student student) {
    this.supervisionGroup.add(student);
    student.allocateSupervisor(this);
  }
  
  public Set<Subject> getSubjects() {
  		return this.subjectsQualifiedToTeach;
  }

  public Set<Student> getSupervisionGroup() {
    Set<Student> unmodifiable = Collections.unmodifiableSet(this.supervisionGroup);
    return unmodifiable;
  }
  
  public Set<Student> getModifiableVisionGroup() {
  		return this.supervisionGroup;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "Tutor: " + this.name + " (" + this.staffId + ")";
  }

	public void createStudentAndAddToSupervisionGroup(String studentName, String enrollmentId, String street, String city, String zip) {
		Student student = new Student(studentName, enrollmentId, street, city, zip);
		this.addStudentToSupervisionGroup(student);
	}
}
