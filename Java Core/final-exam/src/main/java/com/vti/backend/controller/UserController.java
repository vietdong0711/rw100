package com.vti.backend.controller;

import com.vti.backend.service.IUserService;
import com.vti.backend.service.impl.UserServiceImpl;
import com.vti.entity.User;

import java.util.List;

public class UserController {

    private IUserService service = new UserServiceImpl();

    public List<User> findAll() {
        return service.findAll();
    }

    public User findById(Long id) {
        return service.findById(id);
    }

    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }

    public User login(String email, String password) {
        return service.login(email, password);
    }

    public boolean create(String fullName, String email) {
        return service.create(fullName, email);
    }

    public boolean checkExistEmail(String email) {
        return service.checkExistEmail(email);
    }
}
