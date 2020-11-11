package me.ogq.ocp.sample.core.domain.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import me.ogq.ocp.sample.core.domain.subject.Subject;
import org.hibernate.annotations.Cascade;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/04 Time: 6:40 오후
 */
@Entity
@Table(name = "student")
public class StudentOneToMany {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long no;

  private String name;

//  @ManyToOne
//  private Teacher teacher;

  private Grade grade;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Subject> subjects;

  public StudentOneToMany(String name, Grade grade) {
    this.name = name;
    this.grade = grade;
  }

  public void subscribeSubject(Subject subject){
    if(Objects.isNull(this.subjects)) this.subjects = new ArrayList<>();
    this.subjects.add(subject);
  }
}