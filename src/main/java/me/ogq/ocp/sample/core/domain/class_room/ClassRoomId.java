package me.ogq.ocp.sample.core.domain.class_room;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/04 Time: 6:54 오후
 */
@Embeddable
@EqualsAndHashCode
public class ClassRoomId implements Serializable {
  private String id;

  private ClassRoomId(){}

  private ClassRoomId(String id){
    this.id = id;
  }

  public static ClassRoomId of(String id){
    return new ClassRoomId(id);
  }

  @Override
  public String toString(){
    return this.id;
  }
}
