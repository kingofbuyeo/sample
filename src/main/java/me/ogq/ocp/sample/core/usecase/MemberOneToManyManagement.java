package me.ogq.ocp.sample.core.usecase;

import me.ogq.ocp.sample.core.domain.member_one_to_many.MemberDetailWithoutRelation;
import me.ogq.ocp.sample.core.domain.member_one_to_many.MemberOneToMany;
import me.ogq.ocp.sample.core.domain.member_one_to_many.MemberOneToManyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/12 Time: 12:49 오전
 */
@Service
public class MemberOneToManyManagement {
  private final MemberOneToManyRepository memberOneToManyRepository;

  public MemberOneToManyManagement(
      MemberOneToManyRepository memberOneToManyRepository) {
    this.memberOneToManyRepository = memberOneToManyRepository;
  }

  @Transactional
  public void save(){
    MemberOneToMany member = new MemberOneToMany(1,"test");
    memberOneToManyRepository.save(member);
    MemberDetailWithoutRelation detail1 = new MemberDetailWithoutRelation("test");
    MemberDetailWithoutRelation detail2 = new MemberDetailWithoutRelation("test1");

    member.added(detail1);
    member.added(detail2);
  }
}
