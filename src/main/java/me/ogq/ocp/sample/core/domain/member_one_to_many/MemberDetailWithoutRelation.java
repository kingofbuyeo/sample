package me.ogq.ocp.sample.core.domain.member_one_to_many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/11 Time: 8:37 오후
 */
@Entity
@Table(name = "member_detail_without_relation")
public class MemberDetailWithoutRelation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long no;

  private String detail;

  public MemberDetailWithoutRelation(String detail) {
    this.detail = detail;
  }

  public MemberDetailWithoutRelation() {
  }
}
