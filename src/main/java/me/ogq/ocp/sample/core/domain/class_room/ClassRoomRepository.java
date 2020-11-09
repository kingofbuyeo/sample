package me.ogq.ocp.sample.core.domain.class_room;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/08 Time: 1:18 오후
 */
@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, ClassRoomId> {

  /**
   * select * from ClassRoom where className = ?1 limit {begin}, {end}
   * select count(*) from ClassRoom where className = ?1
   * @return
   */
  Page<ClassRoom> findAllByClassName(String name, Pageable pageable);

  /**
   * select * from ClassRoom where className = ?1 limit {begin}, {end + 1}
   * @return
   */
  Slice<ClassRoom> readAllByClassName(String name, Pageable pageable);
}
