package me.ogq.ocp.sample.core.domain.teacher;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/08 Time: 4:12 오후
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
