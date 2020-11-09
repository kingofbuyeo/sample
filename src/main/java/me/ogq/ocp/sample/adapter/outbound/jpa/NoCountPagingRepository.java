package me.ogq.ocp.sample.adapter.outbound.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

// 아래 주소에서 가지고 옴.
// https://github.com/eclipse/hawkbit/blob/master/hawkbit-repository/hawkbit-repository-jpa/src/main/java/org/eclipse/hawkbit/repository/jpa/NoCountPagingRepository.java
@Repository
public class NoCountPagingRepository {
  protected EntityManager em;

  @Autowired
  public NoCountPagingRepository(EntityManager em) {
    this.em = em;
  }

  public <T, I extends Serializable> Slice<T> findAll(final Specification<T> spec, final Pageable pageable,
      final Class<T> domainClass) {
    final SimpleJpaNoCountRepository<T, I> noCountDao = new SimpleJpaNoCountRepository<>(domainClass, em);
    return noCountDao.findAll(spec, pageable);
  }


  public <T, I extends Serializable> Slice<T> findAll(final Pageable pageable, final Class<T> domainClass) {
    final SimpleJpaNoCountRepository<T, I> noCountDao = new SimpleJpaNoCountRepository<>(domainClass, em);
    return noCountDao.findAll(pageable);
  }

  public static class SimpleJpaNoCountRepository<T, I extends Serializable> extends
      SimpleJpaRepository<T, I> {

    public SimpleJpaNoCountRepository(final Class<T> domainClass, final EntityManager em) {
      super(domainClass, em);
    }

    // 위 주소에서 가지고온 readPage는 @Deprecated 되어 파라미터가 다른 메소드를 오버라이딩
    @Override
    protected <S extends T> Page<S> readPage(TypedQuery<S> query, final Class<S> domainClass, Pageable pageable,
        @Nullable Specification<S> spec) {

      int pageSize = 0;
      if (pageable.isPaged()) {

        pageSize = pageable.getPageSize();
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageSize + 1);
      }

      List<S> resultList = query.getResultList();
      boolean hasNext = pageable.isPaged() && resultList.size() > pageSize;
      return new CustomSliceImpl<>(hasNext ? resultList.subList(0, pageSize) : resultList, pageable, hasNext);
    }
  }
}
