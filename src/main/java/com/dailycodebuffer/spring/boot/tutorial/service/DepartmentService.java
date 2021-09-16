package com.dailycodebuffer.spring.boot.tutorial.service;

import com.dailycodebuffer.spring.boot.tutorial.entity.Department;
import com.dailycodebuffer.spring.boot.tutorial.exception.DepartmentNotFoundException;


import java.util.List;


public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getListOfDepartments();

    Department getDeptById(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id);

    Department getDepartmentByDeptName(String name);

    Department getDepartmentIgnoreCase(String name);
}
