package com.example.SpringRest.service;

import com.example.SpringRest.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

import com.example.SpringRest.entity.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> fetchDepartmentList()
    {
        return departmentRepository.findAll();
    }
   
    public Department fetchDepartmentById(Long id)
    {
        Optional<Department> dept = departmentRepository.findById(id);
        return dept.get();
    }

    public void deleteDepartmentById(Long id)
    {
        departmentRepository.deleteById(id);
    }
}