package com.example.SpringRest.service;

import com.example.SpringRest.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;
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

    @Override
    public List<Department> fetchDepartmentList()
    {
        return departmentRepository.findAll();
    }
   
    @Override
    public Department fetchDepartmentById(Long id)
    {
        Optional<Department> dept = departmentRepository.findById(id);
        return dept.get();
    }

    @Override
    public void deleteDepartmentById(Long id)
    {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department)
    {
        Department oldDepartment = departmentRepository.getById(id);

        if(Objects.nonNull(department.getDepartmentName()) && department.getDepartmentName().length()!=0)
            oldDepartment.setDepartmentName(department.getDepartmentName());
        if(Objects.nonNull(department.getDepartmentAddress()) && department.getDepartmentAddress().length()!=0)
            oldDepartment.setDepartmentAddress(department.getDepartmentAddress());
        if(Objects.nonNull(department.getDepartmentCode()) && department.getDepartmentCode().length()!=0)
            oldDepartment.setDepartmentCode(department.getDepartmentCode());
        
            return departmentRepository.save(oldDepartment);
    }

    @Override
    public Department fetchDepartmentByName(String name)
    {
        return departmentRepository.findByDepartmentName(name);
    }
}