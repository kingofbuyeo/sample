package me.ogq.ocp.sample.core.domain.member_one_to_many;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/11 Time: 8:36 오후
 */
@Entity
@Table(name = "member_one_to_many")
public class MemberOneToMany {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long no;
  private String name;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "member_id")
  private List<MemberDetailWithoutRelation> details;

  public MemberOneToMany(long no, String name) {
    this.no = no;
    this.name = name;
  }
  public MemberOneToMany() {  }

  public void added(MemberDetailWithoutRelation detail){
    if(Objects.isNull(this.details)) this.details = new ArrayList<>();
    this.details.add(detail);
  }
}
