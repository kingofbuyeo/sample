package me.ogq.ocp.sample.core.domain.class_room;

import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/04 Time: 6:39 오후
 */
@Entity
@Table(name = "class_room")
public class ClassRoom {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long no;

  @Id
  @Embedded
  @AttributeOverride(name = "id", column = @Column(name = "classRoomId", length = 40))
  private ClassRoomId classRoomId;

  private String className;

  private int classNum;

  @ElementCollection
  @CollectionTable(name = "furniture")
  @BatchSize(size = 100)
  private List<Furniture> furniture;

  public ClassRoom() {
  }
}
