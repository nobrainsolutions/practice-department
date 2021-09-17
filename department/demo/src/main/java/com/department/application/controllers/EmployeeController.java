package com.department.application.controllers;

import com.department.application.services.EmployeeService;
import com.department.application.viewmodels.DepartmentCountViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    /**
     *  This method is used to get gender with ages.
     * @param department
     * @return
     */
    @GetMapping("/{department}")
    public ResponseEntity<String> getEmployeesByDepartment(@PathVariable("department") String department) {
        String result = service.getEmployeesByDepartment(department);
        return new ResponseEntity<String>(result, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<DepartmentCountViewModel>> getEmployeesByGender(@RequestParam("gender") String gender) {
        List<DepartmentCountViewModel> result = service.getEmployeesByGender(gender);
        return new ResponseEntity<List<DepartmentCountViewModel>>(result, new HttpHeaders(), HttpStatus.OK);
    }

}
