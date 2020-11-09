package me.ogq.ocp.sample.core.usecase.specification;

import javax.persistence.criteria.JoinType;
import me.ogq.ocp.sample.core.domain.student.Grade;
import me.ogq.ocp.sample.core.domain.student.Student;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/08 Time: 4:59 오후
 */
public class StudentSpecification  {
  public static Specification<Student> initializeWith(Grade grade){
    return (Specification<Student>) (root, query, builder) -> {
      root.fetch("teacher", JoinType.INNER);
      root.fetch("subjects", JoinType.INNER);
      return builder
          .equal(root.get("grade"), grade);
    };
  }

  public static Specification<Student> with(String name){
    return (Specification<Student>) (root, query, builder) -> builder
        .equal(root.get("name"), name);
  }
}
