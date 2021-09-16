package com.dailycodebuffer.spring.boot.tutorial.service;

import com.dailycodebuffer.spring.boot.tutorial.entity.Department;

import com.dailycodebuffer.spring.boot.tutorial.exception.DepartmentNotFoundException;
import com.dailycodebuffer.spring.boot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getListOfDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDeptById(Long id) throws DepartmentNotFoundException {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if(!departmentOptional.isPresent()) throw new DepartmentNotFoundException("The dept is not found", HttpStatus.NOT_FOUND);
            return departmentOptional.get();

    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);

    }

    @Override
    public Department getDepartmentByDeptName(String name) {
        return departmentRepository.findDepartmentByDeptName(name);
    }

    @Override
    public Department getDepartmentIgnoreCase(String name) {
        return departmentRepository.findDepartmentByDeptNameIgnoreCase(name);
    }



}
