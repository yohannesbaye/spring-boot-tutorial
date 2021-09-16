package com.dailycodebuffer.spring.boot.tutorial.repository;

import com.dailycodebuffer.spring.boot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findDepartmentByDeptName(String name);
//    @Query(value = "", nativeQuery = true)
   Department findDepartmentByDeptNameIgnoreCase(String name);
}
