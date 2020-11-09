package me.ogq.ocp.sample.core.domain.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/09 Time: 2:53 오후
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
