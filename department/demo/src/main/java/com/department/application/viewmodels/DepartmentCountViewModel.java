package com.department.application.viewmodels;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
public class DepartmentCountViewModel {
  String department;
  Long deptCount;

  public DepartmentCountViewModel(String department, Long deptCount) {
    this.department = department;
    this.deptCount = deptCount;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("department", department)
        .append("deptCount", deptCount)
        .toString();
  }
}
