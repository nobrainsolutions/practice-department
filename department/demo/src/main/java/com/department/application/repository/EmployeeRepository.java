package com.department.application.repository;

import com.department.application.entity.Employee;
import com.department.application.viewmodels.DepartmentCountViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  List<Employee> getEmployeesByDepartment(String department);

  @Query("SELECT new com.department.application.viewmodels.DepartmentCountViewModel (department as department, COUNT(department) as deptCount)"
          + " FROM com.department.application.entity.Employee WHERE gender = :gender GROUP BY department")
  List<DepartmentCountViewModel> getEmployeesByGender(String gender);
}
