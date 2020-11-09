package me.ogq.ocp.sample.core.domain.teacher;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import me.ogq.ocp.sample.adapter.outbound.jpa.converter.SubClassListConverter;
import me.ogq.ocp.sample.core.domain.class_room.ClassRoom;
import me.ogq.ocp.sample.core.domain.class_room.ClassRoomId;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/04 Time: 6:38 오후
 */
@Table(name = "teacher")
@Entity
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long no;

  @Column(length = 10)
  private String name;

  @Embedded
  @AttributeOverride(name = "id", column = @Column(name = "classRoomId", length = 40))
  private ClassRoomId classRoomId;

  @Column(length = 500)
  @Convert(converter = SubClassListConverter.class)
  private SubClassList subClass;

  public Teacher() {
  }
}
