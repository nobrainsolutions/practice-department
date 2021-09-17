package com.department.application.services;

import com.department.application.entity.Employee;
import com.department.application.repository.EmployeeRepository;
import com.department.application.viewmodels.DepartmentCountViewModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

  @Autowired EmployeeRepository repository;

  public String getEmployeesByDepartment(String department) {
    List<Employee> employeeList = repository.getEmployeesByDepartment(department);
    String result = "";
    Map<String, String> map = new HashMap<>();
    if (CollectionUtils.isEmpty(employeeList)) {
      result = "No record found for department " + department;
    } else {
      for (Employee employee : employeeList) {
        if (map.size() == 0) {
          map.put(employee.getGender(), employee.getAge().toString());
        } else {
          String mAge = "";
          if (StringUtils.equalsIgnoreCase(employee.getGender(), "M")) {
            mAge = map.get("M");
          } else {
            mAge = map.get("F");
          }
          StringBuilder str = new StringBuilder(mAge);
          str.append("-" + employee.getAge());
          map.put(employee.getGender(), str.toString());
        }
      }
      if (!map.containsKey("M")) {
        map.put("M", "NA");
      } else if (!map.containsKey("F")) {
        map.put("F", "NA");
      }
    }
    return convertMapToJson(map);
  }

  public List<DepartmentCountViewModel> getEmployeesByGender(String gender) {
    List<DepartmentCountViewModel> deptCounts = repository.getEmployeesByGender(gender);

    return deptCounts;
  }

  private String convertMapToJson(Map<String, String> map) {
    ObjectMapper objectMapper = new ObjectMapper();
    String json = "";
    try {
      json = objectMapper.writeValueAsString(map);

    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return json;
  }
}
