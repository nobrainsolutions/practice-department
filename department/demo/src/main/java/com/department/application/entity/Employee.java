package com.department.application.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

  @Id @GeneratedValue private Long id;

  @Column(name = "EMP_NAME", length = 100)
  private String empName;

  @Column(name = "DEPARTMENT", length = 50)
  private String department;

  @Column(name = "AGE", length = 3)
  private Integer age;

  @Column(name = "GENDER", length = 10)
  private String gender;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}
