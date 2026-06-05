package com.vti.backend.service.impl;

import com.vti.backend.repository.IDepartmentRepository;
import com.vti.backend.repository.impl.DepartmentRepositoryImpl;
import com.vti.backend.service.IDepartmentService;
import com.vti.dto.ImportError;
import com.vti.dto.context.DepartmentContext;
import com.vti.dto.csv.DepartmentCsv;
import com.vti.entity.Department;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DepartmentServiceImpl implements IDepartmentService {
    // khởi tạo repository
    IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    @Override
    public List<Department> findAll() {
        // che dấu đi thông tin (ẩn đi thông tin)
        return departmentRepository.findAll();// lấy dc ds từ repository
    }

    @Override
    public boolean create(String name) {
        return departmentRepository.create(name);
    }

    @Override
    public boolean update(int id, String name) {
        return departmentRepository.update(id, name);
    }

    @Override
    public boolean delete(int id) {
        return departmentRepository.delete(id);
    }

    @Override
    public boolean checkExistNameAndIdNot(String name, Integer id) {
        return departmentRepository.checkExistNameAndIdNot(name, id);
    }

    @Override
    public boolean checkExistID(Integer id) {
        int countS = 0;
        return departmentRepository.checkExistID(id);
    }

//    @Override
//    public String importDepartmentFromCSV(String pathName) {//  C:\Users\FPT\Desktop\rw100\csv\input_department.csv
//        // check file có tồn tai ko
//        File file = new File(pathName);
//        if (!file.exists()) {
//            return "File không tồn tại";
//        }
//        // doc du lieu tu file va dua du lieu cho repository de lưu vao DB
//        if (!pathName.endsWith(".csv")) {
//            return "Định dạng file không đúng";
//        }
//        // list thanh cong + list loi
//        List<Department> departments = new ArrayList<>();// chua ds department se dc them moi
//
//        List<ImportError> importErrors = new ArrayList<>();
//        // dữ lieu de validation
//        Map<String, Department> mapByName = departmentRepository.mapByName();
//        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {// doc du lieu tu file
//            String line = br.readLine();// lay dòng dau tien, bo no di
//            while ((line = br.readLine()) != null) {
//                //validation
//                // ko loi thi cho vao list department
//                // loi thi cho vao import error
//                this.validation(line, mapByName, departments, importErrors);
//            }
//            //  luu list department vao DB
//            departmentRepository.createListDepartment(departments);
//
//            // xuat file loi
//            String pathError = "C:\\Users\\FPT\\Desktop\\rw100\\csv\\output_error_department.csv";
//            this.exportFileCSV(importErrors, pathError);
//        } catch (Exception e) {
//        }
//        String message = "";
//        if (importErrors.isEmpty()) {
//            message = "Import thành công";
//        }
//        if (departments.isEmpty()) {
//            message = "Import ko thành công, đã xuất file lỗi csv\\output_error_department.csv";
//        }
//        if (!importErrors.isEmpty() && !departments.isEmpty()) {
//            message = "Import thành công " + departments.size() + " phòng ban, " +
//                    "đã xuất lỗi ra file csv\\output_error_department.csv";
//        }
//        return message;
//    }

    // xuat ra file loi - ghi du lieu ra file
    public void exportFileCSV(List<ImportError> importErrors, String pathError) {
        if (!importErrors.isEmpty()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathError));
                bw.write("department_name,error_message");
                bw.newLine();
                for (ImportError error : importErrors) {
                    String ln = error.getCsv() + "," + String.join("|", error.getMessage());
                    bw.write(ln);
                    bw.newLine();
                }
                bw.flush();
            } catch (Exception e) {
            }
        }
    }

    public void validation(String line, Map<String, Department> mapByName, List<Department> departments,
                           List<ImportError> importErrors) {
        List<String> errors = new ArrayList<>();
        String[] fields = line.split(",");
        String departmentName = fields[0];
        // validation
        if (Objects.isNull(departmentName) || departmentName.trim().isEmpty()) {
            errors.add("Tên phòng ban ko được để trống");
        } else if (departmentName.length() > 100) {
            errors.add("Tên phòng ban ko được dài quá 100 kí tự");
        } else if (mapByName.get(departmentName) != null) {
            errors.add("Tên phòng ban đã tồn tại");
        }
        if (errors.isEmpty()) {
            Department dep = new Department(departmentName);
            departments.add(dep);
            // check tồn tại cho file có nhiều gtri trung lap
            mapByName.put(departmentName, dep);
        } else {
            ImportError importError = new ImportError(line, errors);
            importErrors.add(importError);
        }
    }


    @Override
    public void validation(String line, DepartmentContext context, List<Department> entities, List<ImportError<DepartmentCsv>> importErrors) {
        List<String> errors = new ArrayList<>();// luu lại ds lôi
        String[] fields = line.split(",", -1);
        String departmentName = fields[0];
        // validation
        if (Objects.isNull(departmentName) || departmentName.trim().isEmpty()) {
            errors.add("Tên phòng ban ko được để trống");
        } else if (departmentName.length() > 100) {
            errors.add("Tên phòng ban ko được dài quá 100 kí tự");
        } else if (context.getMapByName().get(departmentName) != null) {
            errors.add("Tên phòng ban đã tồn tại");
        }
        if (errors.isEmpty()) {
            Department dep = new Department(departmentName);
            entities.add(dep);
            // check tồn tại cho file có nhiều gtri trung lap
            context.getMapByName().put(departmentName, dep);
        } else {
            DepartmentCsv csv = new DepartmentCsv(departmentName);
            ImportError importError = new ImportError(csv, errors);
            importErrors.add(importError);
        }
    }

    @Override
    public void saveAll(List<Department> entities) {
        departmentRepository.createListDepartment(entities);
    }

    @Override
    public void exportFileError(List<ImportError<DepartmentCsv>> importErrors, String pathError, String header) {
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

    @Override
    public String importDepartmentFromCSV(String pathName) {//  C:\Users\FPT\Desktop\rw100\csv\input_department.csv
        String pathError = "C:\\Users\\FPT\\Desktop\\rw100\\csv\\output_error_department.csv";
        // lap ra map  -> đưa map vào DepartmentContext
        Map<String, Department> mapByName = departmentRepository.mapByName();
        DepartmentContext context = new DepartmentContext(mapByName);
        String message = this.importFileCSV(pathName, context, pathError);
        return message;
    }

}
