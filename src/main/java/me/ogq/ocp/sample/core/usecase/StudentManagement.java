package me.ogq.ocp.sample.core.usecase;

import java.util.Arrays;
import java.util.List;
import me.ogq.ocp.sample.core.domain.student.Grade;
import me.ogq.ocp.sample.core.domain.student.Student;
import me.ogq.ocp.sample.core.domain.student.StudentRepository;
import me.ogq.ocp.sample.core.domain.subject.Subject;
import me.ogq.ocp.sample.core.domain.subject.SubjectId;
import me.ogq.ocp.sample.core.usecase.specification.StudentSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/08 Time: 5:10 오후
 */
@Service
public class StudentManagement {
  private final StudentRepository studentRepository;

  public StudentManagement(
      StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Transactional
  public void save(){
    Student st = new Student("김용철", Grade.FIRST);

    studentRepository.save(st);

    Subject sb1 = new Subject(SubjectId.of("1"));
    Subject sb2 = new Subject(SubjectId.of("1"));

    st.subscribeSubject(sb1);
    st.subscribeSubject(sb2);
  }

  @Transactional(readOnly = true)
  public List<Student> searchFrom(String name, int page, int pageSize){
    Specification<Student> spec = dynamicSpec(name);
    PageRequest pageRequest = PageRequest.of(page, pageSize);
    List<Student> students = studentRepository.findAllBy(spec, pageRequest);
    return students;
  }

  private Specification<Student> dynamicSpec(String name){
    Specification<Student> spec = StudentSpecification.initializeWith(Grade.FIRST);
    if(!StringUtils.isEmpty(name)){
      spec = spec.and(StudentSpecification.with(name));
    }
    return spec;
  }
}
