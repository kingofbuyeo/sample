package me.ogq.ocp.sample.core.domain.subject;

import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/05 Time: 7:15 오후
 */
@Embeddable
@EqualsAndHashCode
public class SubjectId {
  private String id;

  private SubjectId(){}

  private SubjectId(String id){
    this.id = id;
  }

  public static SubjectId of(String id){
    return new SubjectId(id);
  }

  @Override
  public String toString(){
    return this.id;
  }
}
