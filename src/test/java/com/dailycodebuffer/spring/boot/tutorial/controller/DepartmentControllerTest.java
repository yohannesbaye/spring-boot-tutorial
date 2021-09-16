package com.dailycodebuffer.spring.boot.tutorial.controller;


import com.dailycodebuffer.spring.boot.tutorial.entity.Department;
import com.dailycodebuffer.spring.boot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .deptName("Ahmedabad")
                .deptCode("IT-06")
                .deptAddress("234567 North")
                .depId(1L)
                .build();
    }

    @Test
    @DisplayName("saveDepartmentTestInControllerTestClass")
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .deptName("Ahmedabad")
                .deptCode("IT-06")
                .deptAddress("234567 North")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"deptName\":\"Ahmedabad\",\n" +
                        "\t\"deptAddress\":\"234567 North\",\n" +
                        "\t\"deptCode\":\"IT-06\"\n" +
                        "}"))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("getDepartmentByNameInControllerTest")
    void getDepartmentByName() throws Exception {
        Mockito.when(departmentService.getDeptById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deptName").
                        value(department.getDeptName()));
    }
}