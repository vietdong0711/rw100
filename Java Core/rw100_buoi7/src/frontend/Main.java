package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPosition;
import backend.QLTK;
import entity.Department;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DepartmentFunction.run();
    }


}
