package com.dailycodebuffer.spring.boot.tutorial.service;




import com.dailycodebuffer.spring.boot.tutorial.entity.Department;
import com.dailycodebuffer.spring.boot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
class DepartmentServiceTest {

     @Autowired
    private DepartmentService departmentService;

   @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .deptName("IT")
                        .deptAddress("Ahmedabad")
                        .deptCode("IT-06")
                        .depId(1L)
                        .build();

        Mockito.when(departmentRepository.findDepartmentByDeptName("IT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on Valida Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found2 = departmentService.getDepartmentByDeptName(departmentName);

        assertEquals(departmentName, found2.getDeptName());

    }
}