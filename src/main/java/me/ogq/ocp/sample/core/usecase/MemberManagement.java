package me.ogq.ocp.sample.core.usecase;

import me.ogq.ocp.sample.core.domain.member.Member;
import me.ogq.ocp.sample.core.domain.member.MemberDetail;
import me.ogq.ocp.sample.core.domain.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/12 Time: 12:49 오전
 */
@Service
public class MemberManagement {
  private final MemberRepository memberRepository;

  public MemberManagement(
      MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Transactional
  public void save(){
    Member member = new Member(1,"test");
    memberRepository.save(member);
    MemberDetail detail1 = new MemberDetail(1,"test");
    MemberDetail detail2 = new MemberDetail(2, "test1");

    member.added(detail1);
    member.added(detail2);
    memberRepository.save(member);
  }
}