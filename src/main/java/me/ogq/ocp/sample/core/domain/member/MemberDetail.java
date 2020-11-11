package me.ogq.ocp.sample.core.domain.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/11 Time: 8:37 오후
 */
@Entity
@Table(name = "member_detail")
public class MemberDetail {
  @Id
  private long no;
  private String detail;
  @ManyToOne
  private Member member;
  public MemberDetail(long no, String detail) {
    this.no = no;
    this.detail = detail;
  }
  public MemberDetail() {  }
}
