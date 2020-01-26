package com.cars24.demo.utils;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;

// http://modelmapper.org/examples/
@Slf4j
public class ObjectMapperUtil {

  ModelMapper modelMapper = new ModelMapper();

  public static <T> T mapper(Object source, Class<T> target) {
    try {
      if (source == null)
        return null;
      return new ModelMapper().map(source, target);
    } catch (Exception e) {
      log.info("Exception during the DTO conversions  is {}", e);
      return null;
    }
  }

  public static <T> List<T> listMapper(List<?> sourceList, Class<T> target) {
    try {
      if (CollectionUtils.isEmpty(sourceList))
        return null;
      List<T> targetList = new ArrayList<T>();
      for (Object source : sourceList) {
        targetList.add(mapper(source, target));
      }
      return targetList;
    } catch (Exception e) {
      log.info("Exception during the list of DTO conversions  is {}", e);
      return null;
    }
  }

  public static ModelMapper modelMapper() {
    return new ModelMapper();
  }

  /*
   * @Data public static class A {
   * 
   * private String name; private LocalDateTime date; }
   * 
   * @Data public static class B { private String name; private LocalDateTime date; }
   * 
   * public static void main(String st[]) {
   * 
   * A a = new A(); a.setDate(LocalDateTime.now()); a.setName("sohan");
   * System.out.println(a.toString());
   * 
   * B b = ObjectMapperUtil.convertDTO(a, B.class);
   * 
   * System.out.println(b.toString()); }
   */

}
