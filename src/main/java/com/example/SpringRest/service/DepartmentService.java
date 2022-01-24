package com.example.SpringRest.service;
import java.util.List;

import com.example.SpringRest.entity.Department;


public interface DepartmentService 
{
    public Department saveDepartment(Department department);
    public List<Department> fetchDepartmentList();
    public Department fetchDepartmentById(Long id);
    public void deleteDepartmentById(Long id);
}
