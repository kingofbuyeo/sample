package me.ogq.ocp.sample.core.usecase;

import java.util.Arrays;
import me.ogq.ocp.sample.core.domain.member_detail_many_to_one.MemberDetailManyToOne;
import me.ogq.ocp.sample.core.domain.member_detail_many_to_one.MemberDetailManyToOneRepository;
import me.ogq.ocp.sample.core.domain.member_detail_many_to_one.MemberWithoutRelation;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/12 Time: 12:25 오전
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberWithoutRelationTest {
  @Autowired
  private MemberDetailManyToOneRepository memberDetailManyToOneRepository;

  @Test
  public void 멤버_다대일_테스트(){
    MemberWithoutRelation member = new MemberWithoutRelation("테스트");

    MemberDetailManyToOne detail1 = new MemberDetailManyToOne("테스트", member);
    MemberDetailManyToOne detail2 = new MemberDetailManyToOne("테스트", member);
    memberDetailManyToOneRepository.saveAll(Arrays.asList(detail1, detail2));
  }
}
