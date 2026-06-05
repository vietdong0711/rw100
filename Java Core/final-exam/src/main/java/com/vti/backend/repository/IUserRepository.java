package com.vti.backend.repository;

import com.vti.entity.User;

import java.util.List;

public interface IUserRepository {

    List<User> findAll();//câu 2
    User findById(Long id);//câu 3
    boolean deleteById(Long id);//câu 4
    User login(String email, String password);// câu 5
    boolean create(String fullName, String email);// câu 6
    boolean checkExistEmail(String email);
}
