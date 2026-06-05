package com.vti.backend.service;

import com.vti.dto.ImportError;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public interface ImportFileCSV<T, K, E> {
    // T la context: chứa dữ liệu để validation
    // K là entity: Acccount, Department, liên quan đến ds ko có lỗi
    // E là đối tượng map  vói file csv   DepartmentCSV, AccountCSV   -> đưa vào file lỗi
    void validation(String line, T context, List<K> entities, List<ImportError<E>> importErrors);

    void saveAll(List<K> entities);

    void exportFileError(List<ImportError<E>> importErrors, String pathError, String header);

    default String importFileCSV(String pathName, T context, String pathError) {
        File file = new File(pathName);
        if (!file.exists()) {
            return "File không tồn tại";
        }
        if (!pathName.endsWith(".csv")) {
            return "File ko đúng định dạng!";
        }
        List<K> entities = new ArrayList<>();// khoi tao 1 list de chua cac enity ko có lỗi  -> lưu vào DB
        List<ImportError<E>> importErrors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            String line = "";
            String header = br.readLine();// bo di line dau tien
            while ((line = br.readLine()) != null) {
                this.validation(line, context, entities, importErrors);
            }
            // lưu dữ liêu vao DB
            this.saveAll(entities);
            // xuát file loi
            this.exportFileError(importErrors, pathError, header);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String message = "";
        if (importErrors.isEmpty()) {
            message = "Import thành công";
        }
        if (entities.isEmpty()) {
            message = "Import ko thành công, đã xuất file lỗi " + pathError;
        }
        if (!importErrors.isEmpty() && !entities.isEmpty()) {
            message = "Import thành công " + entities.size() +
                    ", đã xuất lỗi ra file " + pathError;
        }
        return message;
    }
}
