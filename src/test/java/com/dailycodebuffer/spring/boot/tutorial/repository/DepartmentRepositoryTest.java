package com.dailycodebuffer.spring.boot.tutorial.repository;




import com.dailycodebuffer.spring.boot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .deptName("Mechanical Engineering")
                        .deptCode("ME - 011")
                        .deptAddress("Delhi")
                        .build();

        entityManager.persist(department);
    }

    @Test
    @DisplayName("RepostioryTestFindByIdHappyResult")
    public void whenFindById_thenReturnDepartment() {
        Department depart= departmentRepository.findById(1L).get();
        assertEquals(depart.getDeptName(), "Mechanical Engineering");
    }
}
