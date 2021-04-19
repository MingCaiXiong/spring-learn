package top.xiongmingcai.springmvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MtDateConverter implements Converter<String, Date> {

  @Override
  public Date convert(String s) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date parse = null;
    try {
      parse = sdf.parse(s);
    } catch (ParseException e) {

    }
    return parse;
  }
}
