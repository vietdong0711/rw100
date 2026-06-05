package com.vti.backend.service;

import com.vti.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    boolean deleteById(Long id);
    User login(String email, String password);
    boolean create(String fullName, String email);
    boolean checkExistEmail(String email);
}
