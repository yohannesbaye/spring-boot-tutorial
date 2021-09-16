package com.dailycodebuffer.spring.boot.tutorial.controller;

import com.dailycodebuffer.spring.boot.tutorial.entity.Department;

import com.dailycodebuffer.spring.boot.tutorial.exception.DepartmentNotFoundException;
import com.dailycodebuffer.spring.boot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

  //  This is how to read files from the application.properties.
    @Value("${welcome.message}")
    private String welcome;

//    @Value("${spring.application.name}")
//    private String name;

       //to add loggers
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
 @GetMapping()
 public String welcomePage(){
     return welcome; //+ ": "+ name;
 }
    @GetMapping("/all")
    public List<Department> getAllDepartments(){
        LOGGER.info("Inside The getAllDepartment Methode in the DepartmentController class");
        return departmentService.getListOfDepartments();
    }
    

    @PostMapping("/departments/add")
    public Department seveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside save department Methode");
        return departmentService.saveDepartment(department);
    }

        @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
     Department dept = departmentService.getDeptById(id);
      if(dept == null) throw new DepartmentNotFoundException("Department with id: "+ id +" is not found", HttpStatus.NOT_FOUND);
//            try {
//                dept =  departmentService.getDeptById(id);
//            } catch (DepartmentNotFoundException exception) {
//                exception.printStackTrace();
//            }
           return  dept;
        }

        @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        Department dept = getDepartmentById(id);
        if(dept==null) throw new DepartmentNotFoundException("No department with id: "+ id, HttpStatus.NOT_FOUND);
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>("department is deleted Successfully", HttpStatus.OK);
        }
        @PutMapping("/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long id, @RequestBody Department department) throws DepartmentNotFoundException {
            Department oldDept = getDepartmentById(id);
          if(oldDept == null){
            departmentService.saveDepartment(department);
          }else{
              oldDept.setDeptName(department.getDeptName());
              oldDept.setDeptAddress(department.getDeptAddress());
              oldDept.setDeptCode(department.getDeptCode());
          }
          return oldDept;
        }

        @GetMapping("/name/{name}")
        public  Department fetchByName(@PathVariable("name")  String name){
        return departmentService.getDepartmentByDeptName(name);

        }

          @GetMapping("/Case/{name}")
        public Department getDepartmentNameIgnoreCase(@PathVariable("name") String name){
             name.toLowerCase();

         return departmentService.getDepartmentIgnoreCase(name);
          }
}
