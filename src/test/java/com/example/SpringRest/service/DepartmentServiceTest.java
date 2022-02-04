package com.example.SpringRest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.SpringRest.entity.Department;
import com.example.SpringRest.repository.DepartmentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DepartmentServiceTest 
{

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp()
    {
        Department department = Department.builder().departmentName("IT").departmentCode("IT100").departmentAddress("ITBLOCK").departmentId(1L).build();

        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on valid department name")
    public void whenValidDepartmentName_departmentShouldBeReturned()
    {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(found.getDepartmentName(), departmentName);

    }
}
