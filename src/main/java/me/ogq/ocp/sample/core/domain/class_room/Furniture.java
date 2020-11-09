package me.ogq.ocp.sample.core.domain.class_room;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/05 Time: 7:23 오후
 */
@Entity
@Table(name = "furniture")
public class Furniture {
  enum FurnitureType {
    WOOD, PLASTIC
  }
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long no;

  private String name;

  @Enumerated(EnumType.STRING)
  private FurnitureType type;
}
