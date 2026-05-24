package com.vti.backend.service.impl;

import com.vti.backend.repository.IAccountRepository;
import com.vti.backend.repository.IDepartmentRepository;
import com.vti.backend.repository.IPositionRepository;
import com.vti.backend.repository.impl.AccountRepositoryImpl;
import com.vti.backend.repository.impl.DepartmentRepositoryImpl;
import com.vti.backend.repository.impl.PositionRepositoryImpl;
import com.vti.backend.service.IAccountService;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountServiceImpl implements IAccountService {
    // khoi tao accountRepository
    private IAccountRepository accountRepository = new AccountRepositoryImpl();
    private IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    private IPositionRepository positionRepository = new PositionRepositoryImpl();


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
    public boolean checkUsernameExist(String username, Integer id) {
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

    @Override
    public String importAccountFromCSV(String pathName) {
        if (!pathName.endsWith(".csv")) {
            return "File ko đúng định dạng!";
        }
        List<Account> accounts = new ArrayList<>();
        boolean firstLine = true;
        boolean checkImport = false;
        String header = "";
        int accountID = 0;
        List<Department> departments = departmentRepository.findAll();// kiem tra xem departmentID import vao co ton tai hay ko
        List<Position> positions = positionRepository.findAll();
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            header = br.readLine();// bo di dong header
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", -1);
                List<String> errors = new ArrayList<>();
                String username = fields[0];
                String fullName = fields[1];
                String email = fields[2];
                String departmentId = fields[3];
                String positionId = fields[4];

                Department department = null;
                for (Department de : departments) {
                    if (de.getId() == Integer.parseInt(departmentId)) {
                        department = de;
                        break;
                    }
                }

                Position position = null;
                for (Position po : positions) {
                    if (po.getId() == Integer.parseInt(positionId)) {
                        position = po;
                        break;
                    }
                }
                Account account = new Account(username, fullName, email, department, position);
                accounts.add(account);
            }
            if (!accounts.isEmpty()) {
                checkImport = accountRepository.createAccounts(accounts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  "Import thành công";
    }
}
