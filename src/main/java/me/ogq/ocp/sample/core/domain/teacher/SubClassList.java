package me.ogq.ocp.sample.core.domain.teacher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/08 Time: 6:49 오후
 */
@EqualsAndHashCode
public class SubClassList {
  private final List<String> subClassList;

  private SubClassList(List<String> subClassList) {
    this.subClassList = subClassList;
  }

  public List<String> list() {
    return subClassList;
  }

  public String toString() {
    if(Objects.isNull(subClassList) || subClassList.isEmpty()){
      return null;
    }
    return String.join(",", subClassList);
  }

  public static SubClassList of(String tagStr) {
    if(StringUtils.isEmpty(tagStr)) {
      return new SubClassList(Collections.emptyList());
    }
    String [] tokens = tagStr.split(",");
    List<String> tags = Arrays.stream(tokens).map(String::strip)
        .filter(each -> each.length() > 0).collect(Collectors.toList());
    return new SubClassList(tags);
  }

  public static SubClassList withStrList(List<String> tags){
    return new SubClassList(tags);
  }
}
