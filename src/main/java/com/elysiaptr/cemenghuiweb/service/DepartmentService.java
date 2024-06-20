package com.elysiaptr.cemenghuiweb.service;

import com.elysiaptr.cemenghuiweb.po.Department;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department updateDepartment(Long id, Department departmentDetails);

    void deleteDepartment(Long id);

    Department getDepartmentById(Long id);

    List<Department> getAllDepartments();

    Page<Department> getDepartmentsByPage(int page, int size);
}