package core.jee.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Tutor {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String staffId;
  private String name;
  private int salary;

  @OneToMany(mappedBy="supervisor")
  //@OrderColumn(name="student_order")
  //@MapKey(name="enrollmentID")
  //@JoinColumn(name="TUTOR_FK")
  private List<Student> supervisionGroup;

  public Tutor() {/*Required by Hiberante*/}

  // "Business constructor"
  public Tutor(String staffId, String name, int salary) {
    super();
    this.staffId = staffId;
    this.name = name;
    this.salary = salary;
    this.supervisionGroup = new ArrayList<>();
  }

  public void addStudentToSupervisionGroup(Student student) {
    this.supervisionGroup.add(student);
    student.allocateSupervisor(this);
  }

  public List<Student> getSupervisionGroup() {
    List<Student> unmodifiable = Collections.unmodifiableList(this.supervisionGroup);
    return unmodifiable;
  }
  
  public List<Student> getModifiableVisionGroup() {
  		return this.supervisionGroup;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "Tutor: " + this.name + " (" + this.staffId + ")";
  }
}
