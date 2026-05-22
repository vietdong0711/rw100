package com.vti.backend.service.impl;

import com.vti.backend.repository.IAccountRepository;
import com.vti.backend.repository.impl.AccountRepositoryImpl;
import com.vti.backend.service.IAccountService;
import com.vti.entity.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AccountServiceImpl implements IAccountService {
    // khoi tao accountRepository
    private IAccountRepository accountRepository = new AccountRepositoryImpl();


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public boolean create(String email, String username, String fullName, int departmentID, int positionID) {
        return accountRepository.create(email, username, fullName, departmentID, positionID);
    }

    @Override
    public boolean update(int id, String updateName, String email, String username, int departmentId, int positionId) {
        return accountRepository.update(id, updateName, email, username, departmentId, positionId);
    }

    @Override
    public boolean delete(int id) {
        return accountRepository.delete(id);
    }

    @Override
    public Map<String, Account> mapAccountByUsername() {
        return accountRepository.mapAccountByUsername();
    }

    @Override
    public boolean checkUsernameExist(String username,  Integer id) {
        return accountRepository.checkUsernameExist(username, id);
    }

    @Override
    public boolean checkEmailExist(String email) {
        return accountRepository.checkEmailExist(email);
    }

    @Override
    public boolean checkIdExist(Integer id) {
        return accountRepository.checkIdExist(id);
    }

    @Override
    public boolean update(int id, String updateName) {
        return accountRepository.update(id, updateName);
    }
}
