package com.dailycodebuffer.spring.boot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //Comes from the Lombox dependency
public class Department {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Long depId;

    @NotBlank(message = "please Add Department Name")
    private String deptName;
    private String deptAddress;
    private  String deptCode;

    //Avaliable validations in spring boot

//    @Length(max = 15, min= 1)
//    @Size(max = 20, min= 0)
    //@Email
    //@Positive
//    @FutureOrPresent
//    @Past
//    @PositiveOrZero




    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", deptName='" + deptName + '\'' +
                ", deptAddress='" + deptAddress + '\'' +
                ", deptCode='" + deptCode + '\'' +
                '}';
    }
}
