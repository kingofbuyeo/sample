package me.ogq.ocp.sample.adapter.outbound.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import me.ogq.ocp.sample.core.domain.teacher.SubClassList;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/08 Time: 6:50 오후
 */
@Converter
public class SubClassListConverter implements AttributeConverter<SubClassList, String> {

  @Override
  public String convertToDatabaseColumn(SubClassList attribute) {
    return attribute.toString();
  }

  @Override
  public SubClassList convertToEntityAttribute(String dbData) {
    return SubClassList.of(dbData);
  }
}
