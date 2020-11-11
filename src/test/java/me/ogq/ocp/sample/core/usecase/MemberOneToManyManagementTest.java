package me.ogq.ocp.sample.core.usecase;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/12 Time: 12:53 오전
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberOneToManyManagementTest {
  @Autowired
  private MemberOneToManyManagement memberOneToManyManagement;

  @Test
  public void 멤버_일대다_테스트(){
    memberOneToManyManagement.save();
  }
}
