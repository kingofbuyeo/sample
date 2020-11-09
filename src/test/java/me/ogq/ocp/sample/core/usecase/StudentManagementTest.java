package me.ogq.ocp.sample.core.usecase;

import java.util.Arrays;
import java.util.List;
import me.ogq.ocp.sample.core.domain.student.Grade;
import me.ogq.ocp.sample.core.domain.student.Student;
import me.ogq.ocp.sample.core.domain.student.StudentRepository;
import me.ogq.ocp.sample.core.domain.subject.Subject;
import me.ogq.ocp.sample.core.domain.subject.SubjectId;
import me.ogq.ocp.sample.core.domain.subject.SubjectRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/08 Time: 5:45 오후
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class StudentManagementTest {
  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private SubjectRepository subjectRepository;

  @Autowired
  private StudentManagement studentManagement;

  @Test
  void 다대일_영속성전이_테스트() {
//    Student st = new Student("김용철", Grade.FIRST);

//    Subject sb1 = new Subject(SubjectId.of("1"), st);
//    Subject sb2 = new Subject(SubjectId.of("1"), st);
//
//    subjectRepository.saveAll(Arrays.asList(sb1, sb2));
  }

  @Test
  void 일대다_영속성전이_테스트(){
    studentManagement.save();
  }
}