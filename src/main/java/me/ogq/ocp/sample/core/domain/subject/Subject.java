package me.ogq.ocp.sample.core.domain.subject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import me.ogq.ocp.sample.core.domain.student.Student;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/05 Time: 7:15 오후
 */
@Entity
@Table(name = "subject")
public class Subject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long no;

  private SubjectId subjectId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "student_id")
  private Student student;
  public Subject(){}
  public Subject(SubjectId subjectId) {
    this.subjectId = subjectId;
  }
  public Subject(SubjectId subjectId, Student student){
    this.subjectId = subjectId;
    this.student = student;
  }
}
