package me.ogq.ocp.sample.core.domain.student;

import java.util.Collection;
import java.util.List;
import me.ogq.ocp.sample.core.domain.StudentNameOnly;
import me.ogq.ocp.sample.core.domain.StudentProjection;
import me.ogq.ocp.sample.core.domain.teacher.Teacher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/08 Time: 4:14 오후
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  @EntityGraph(type = EntityGraphType.FETCH, attributePaths = {"subjects", "teacher"})
  List<Student> findByGrade(Grade grade);

//  @Query("SELECT s FROM Student s JOIN FETCH s.teacher JOIN FETCH s.subjects "
//      + " WHERE s.grade = ?1 ")
//  List<Student> findByGradeWithJpql(Grade grade);

  /**
   * select * from student sd
   * left outer join
   * subject sb on sd.no=sb.student_no where sb.no=?
   */
  List<Student> findBySubjects_No(long subjectId);

  List<Student> findAllBy(Specification<Student> spec, Pageable pageable);



  Collection<StudentProjection> findByGradeIn(List<Grade> grade);

//  Collection<StudentNameOnly> findByGrade(Teacher teacher);

  <T> Collection<T> findByName(String name, Class<T> type);
}
