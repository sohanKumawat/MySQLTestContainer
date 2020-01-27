package com.cars24.demo.test.dateprovider;

import com.cars24.demo.bean.EmployeeBean;

public class DataProvider {

  public static EmployeeBean getEmployee() {

    return EmployeeBean.builder().department("Tech").name("Sohan").salary("1L").build();
  }

}
