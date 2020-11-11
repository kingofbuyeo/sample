package me.ogq.ocp.sample.core.domain.member_detail_many_to_one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/11 Time: 8:36 오후
 */
@Entity
@Table(name = "member_without_relation")
public class MemberWithoutRelation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long no;

  private String name;

  public MemberWithoutRelation(String name) {
    this.name = name;
  }

  public MemberWithoutRelation(){}
}
