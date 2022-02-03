package com.example.SpringRest.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import javax.validation.Valid;

import com.example.SpringRest.entity.Department;
import com.example.SpringRest.service.DepartmentService;

@RestController
public class DepartmentController 
{

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger =LoggerFactory.getLogger(DepartmentController.class);    
    
    
    // Endpoints

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) 
    {
        logger.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        logger.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();

    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId)
    {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
    {
        departmentService.deleteDepartmentById(departmentId);
        return "Department "+departmentId+" deleted successfully"; 
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) 
    {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String name)
    {
        return departmentService.fetchDepartmentByName(name);
    }
}