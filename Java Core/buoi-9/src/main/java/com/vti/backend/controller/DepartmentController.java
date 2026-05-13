package com.vti.backend.controller;

import com.vti.backend.service.IDepartmentService;
import com.vti.backend.service.impl.DepartmentServiceImpl;
import com.vti.entity.Department;

import java.util.List;

public class DepartmentController {
    // khoi tao departmentService
    private IDepartmentService departmentService = new DepartmentServiceImpl();

    public List<Department> findAll() {
        // lay ds tu service
        List<Department> departments = departmentService.findAll();
        return departments;
    }

    public boolean create(String name) {
        boolean check = departmentService.create(name);
        return check;
    }

    public boolean delete(int id) {
        boolean check = departmentService.delete(id);
        return check;
    }

    public boolean update(int id, String updateName) {
        boolean check = departmentService.update(id, updateName);
        return check;
    }
}
