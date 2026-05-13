package com.vti.backend.service.impl;

import com.vti.backend.repository.IDepartmentRepository;
import com.vti.backend.repository.impl.DepartmentRepositoryImpl;
import com.vti.backend.service.IDepartmentService;
import com.vti.entity.Department;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    // khoi tao doi tuong departmentRepository
    private IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    @Override
    public List<Department> findAll() {
        // lay ra ds department tu repository
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    @Override
    public boolean create(String name) {
        boolean check = departmentRepository.create(name);
        return check;
    }

    @Override
    public boolean delete(int id) {
        boolean check = departmentRepository.delete(id);
        return check;
    }

    @Override
    public boolean update(int id, String updateName) {
        boolean check = departmentRepository.update(id, updateName);
        return check;
    }


}
