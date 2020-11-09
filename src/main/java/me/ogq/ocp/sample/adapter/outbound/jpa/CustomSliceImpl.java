package me.ogq.ocp.sample.adapter.outbound.jpa;

import java.util.List;
import java.util.function.Function;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.SliceImpl;

public class CustomSliceImpl<T> extends SliceImpl<T> implements Page<T> {
  public CustomSliceImpl(List<T> content, Pageable pageable, boolean hasNext) {
    super(content, pageable, hasNext);
  }

  @Override
  public int getTotalPages() {
    return 0;
  }

  @Override
  public long getTotalElements() {
    return 0;
  }

  @Override
  public <U> Page<U> map(Function<? super T, ? extends U> converter) {
    return new PageImpl<>(getConvertedContent(converter), getPageable(), 0);
  }
}
