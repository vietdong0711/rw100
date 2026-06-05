package com.vti.backend.service.impl;

import com.vti.backend.repository.IAccountRepository;
import com.vti.backend.repository.IDepartmentRepository;
import com.vti.backend.repository.IPositionRepository;
import com.vti.backend.repository.impl.AccountRepositoryImpl;
import com.vti.backend.repository.impl.DepartmentRepositoryImpl;
import com.vti.backend.repository.impl.PositionRepositoryImpl;
import com.vti.backend.service.IAccountService;
import com.vti.dto.ImportError;
import com.vti.dto.context.AccountContext;
import com.vti.dto.csv.AccountCsv;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.ScannerUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
        List<Department> departments = departmentRepository.findAll();
        List<Position> positions = positionRepository.findAll();
//        Map<String, Account> mapByUsername = accountRepository.mapByUsername();
//        Map<String, Account> mapByEmail = accountRepository.mapAccountByEmail();
        List<Account> accounts = accountRepository.findAll();
        Map<String, Account> mapByUsername = accounts.stream()
                .collect(Collectors.toMap(acc -> acc.getUsername(), acc -> acc));
        Map<String, Account> mapByEmail = accounts.stream()
                .collect(Collectors.toMap(acc -> acc.getEmail(), acc -> acc));

        AccountContext context = new AccountContext(departments, mapByEmail, mapByUsername, positions);

        String patError = "C:\\Users\\FPT\\Desktop\\rw100\\csv\\output_error_account.csv";
        String message = this.importFileCSV(pathName, context, patError);
        return message;
    }

//    public void validation(String line, Map<String, Account> mapByUsername, Map<String, Account> mapByEmail,
//                           List<Department> departments, List<Position> positions, List<Account> accountSuccess,
//                           List<ImportError<AccountCsv>> importErrors) {
//        String[] fields = line.split(",", -1);
//        List<String> errors = new ArrayList<>();
//        String username = fields[0];
//        String email = fields[1];
//        String fullName = fields[2];
//        String departmentId = fields[3];//"1"  "2"
//        String positionId = fields[4];
//        AccountCsv accountCsv = new AccountCsv(email, fullName, username, departmentId, positionId);
//
//        //validation
//        if (Objects.isNull(username) || username.trim().isEmpty()) {
//            errors.add("Username không dc để trống");
//        } else if (mapByUsername.get(username) != null) {// check xem username da ton tai chua
//            errors.add("Username đã tồn tại");
//        }
//
//        if (Objects.isNull(email) || email.trim().isEmpty()) {
//            errors.add("Email không dc để trống");
//        } else if (!email.matches(ScannerUtils.EMAIL_REGEX)) {// kiểm tra  định dạng email "a@b"
//            errors.add("Email không đúng định dạng");
//        } else if (mapByEmail.get(email) != null) {// check xem username da ton tai chua
//            errors.add("Email đã tồn tại");
//        }
//
//        if (Objects.isNull(fullName) || fullName.trim().isEmpty()) {
//            errors.add("FullName không dc để trống");
//        }
//
//        // kiêm tra xem day phai la so hay ko
//        Department department = null;
//        if (!departmentId.matches(ScannerUtils.NUMBER_REGEX)) {
//            errors.add("DepartmentId phải là số");
//        } else {
//            // kiểm tra xem departmentId có tồn tại ko
//            boolean checkDepartment = false;
//            for (Department de : departments) {
//                if (de.getId() == Integer.parseInt(departmentId)) {
//                    department = de;
//                    checkDepartment = true;
//                    break;
//                }
//            }
//            if (!checkDepartment) {
//                errors.add("DepartmentId này không tồn tại");
//            }
//        }
//
//        // kiêm tra xem day phai la so hay ko
//        Position position = null;
//        if (!positionId.matches(ScannerUtils.NUMBER_REGEX)) {
//            errors.add("PositionId phải là số");
//        } else {
//            // kiểm tra xem positionId có tồn tại ko
//            boolean checkPosition = false;
//            for (Position po : positions) {
//                if (po.getId() == Integer.parseInt(positionId)) {
//                    position = po;
//                    checkPosition = true;
//                    break;
//                }
//            }
//            if (!checkPosition) {
//                errors.add("PositionId này không tồn tại");
//            }
//        }
//        if (errors.isEmpty()) {// nếu ko có 1 loi nao
//            Account account = new Account(username, fullName, email, department, position);
//            accountSuccess.add(account);
//
//            mapByEmail.put(email, account);
//            mapByUsername.put(username, account);
//        } else {
//            // them line lỗi + ds lỗi liên quan vao list de ti nữa xuat file loi
//            ImportError<AccountCsv> error = new ImportError(accountCsv, errors);
//            importErrors.add(error);
//        }
//    }

//    public void exportCSV(String header, String pathError, List<ImportError<AccountCsv>> importErrors) {
//        if (!importErrors.isEmpty()) {
//            try {
//                BufferedWriter bw = new BufferedWriter(new FileWriter(pathError));
//                bw.write(header + ",error_message");
//                bw.newLine();
//                for (ImportError error : importErrors) {
//                    String ln = error.getCsv().toString() + "," + String.join("|", error.getMessage());
//                    bw.write(ln);
//                    bw.newLine();
//                }
//                bw.flush();
//            } catch (Exception e) {
//            }
//        }
//    }

    @Override
    public void validation(String line, AccountContext context, List<Account> entities, List<ImportError<AccountCsv>> importErrors) {
        String[] fields = line.split(",", -1);
        List<String> errors = new ArrayList<>();
        String username = fields[0];
        String email = fields[1];
        String fullName = fields[2];
        String departmentId = fields[3];//"1"  "2"
        String positionId = fields[4];
        AccountCsv accountCsv = new AccountCsv(email, fullName, username, departmentId, positionId);

        //validation
        if (Objects.isNull(username) || username.trim().isEmpty()) {
            errors.add("Username không dc để trống");
        } else if (context.getMapAccountByUsername().get(username) != null) {// check xem username da ton tai chua
            errors.add("Username đã tồn tại");
        }

        if (Objects.isNull(email) || email.trim().isEmpty()) {
            errors.add("Email không dc để trống");
        } else if (!email.matches(ScannerUtils.EMAIL_REGEX)) {// kiểm tra  định dạng email "a@b"
            errors.add("Email không đúng định dạng");
        } else if (context.getMapAccountByEmail().get(email) != null) {// check xem username da ton tai chua
            errors.add("Email đã tồn tại");
        }

        if (Objects.isNull(fullName) || fullName.trim().isEmpty()) {
            errors.add("FullName không dc để trống");
        }

        // kiêm tra xem day phai la so hay ko
        Department department = null;
        if (!departmentId.matches(ScannerUtils.NUMBER_REGEX)) {
            errors.add("DepartmentId phải là số");
        } else {
            // kiểm tra xem departmentId có tồn tại ko
            boolean checkDepartment = false;
            for (Department de : context.getDepartments()) {
                if (de.getId() == Integer.parseInt(departmentId)) {
                    department = de;
                    checkDepartment = true;
                    break;
                }
            }
            if (!checkDepartment) {
                errors.add("DepartmentId này không tồn tại");
            }
        }

        // kiêm tra xem day phai la so hay ko
        Position position = null;
        if (!positionId.matches(ScannerUtils.NUMBER_REGEX)) {
            errors.add("PositionId phải là số");
        } else {
            // kiểm tra xem positionId có tồn tại ko
            boolean checkPosition = false;
            for (Position po : context.getPositions()) {
                if (po.getId() == Integer.parseInt(positionId)) {
                    position = po;
                    checkPosition = true;
                    break;
                }
            }
            if (!checkPosition) {
                errors.add("PositionId này không tồn tại");
            }
        }
        if (errors.isEmpty()) {// nếu ko có 1 loi nao
            Account account = new Account(username, fullName, email, department, position);
            entities.add(account);

            context.getMapAccountByEmail().put(email, account);
            context.getMapAccountByUsername().put(username, account);
        } else {
            // them line lỗi + ds lỗi liên quan vao list de ti nữa xuat file loi
            ImportError<AccountCsv> error = new ImportError(accountCsv, errors);
            importErrors.add(error);
        }
    }

    @Override
    public void saveAll(List<Account> entities) {
        if (!entities.isEmpty()) {
            accountRepository.createAccounts(entities);
        }
    }

    @Override
    public void exportFileError(List<ImportError<AccountCsv>> importErrors, String pathError, String header) {
        if (!importErrors.isEmpty()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathError));
                bw.write(header + ",error_message");
                bw.newLine();
                for (ImportError error : importErrors) {
                    String ln = error.getCsv().toString() + "," + String.join("|", error.getMessage());
                    bw.write(ln);
                    bw.newLine();
                }
                bw.flush();
            } catch (Exception e) {
            }
        }
    }
}
