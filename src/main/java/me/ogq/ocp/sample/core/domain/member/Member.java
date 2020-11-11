package me.ogq.ocp.sample.core.domain.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/11 Time: 8:36 오후
 */
@Entity
@Table(name = "member")
public class Member {
  @Id
  private long no;
  private String name;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
  private List<MemberDetail> details;
  public Member(long no, String name) {
    this.no = no;
    this.name = name;
  }
  public Member() {  }
  public void added(MemberDetail detail){
    if(Objects.isNull(this.details)) this.details = new ArrayList<>();
    this.details.add(detail);
  }
}
