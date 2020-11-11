package me.ogq.ocp.sample.core.domain.member_detail_many_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/11 Time: 8:37 오후
 */
@Entity
@Table(name = "member_detail_many_to_one")
public class MemberDetailManyToOne {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long no;

  private String detail;

  @ManyToOne(cascade = CascadeType.ALL)
  private MemberWithoutRelation member;

  public MemberDetailManyToOne(String detail,
      MemberWithoutRelation member) {
    this.detail = detail;
    this.member = member;
  }
}
