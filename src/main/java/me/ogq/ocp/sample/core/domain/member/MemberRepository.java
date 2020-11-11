package me.ogq.ocp.sample.core.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/11 Time: 8:39 오후
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
