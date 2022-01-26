package com.example.SpringRest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;


@Entity
@Data
public class Department 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Department name should not be blank!")
    @Length(min = 1, max=5)
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    
}

