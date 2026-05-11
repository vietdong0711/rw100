package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPosition;
import backend.QLTK;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        QLTK.run();

//        Account account = new Account();
//        //class //object
//        account.getId();
//
//        Account.showId();
//        QLDepartment.showDepartment();
//        QLDepartment.showDepartmentGreaterOrEqualsTo2();
//        QLPosition.showPosition();
//        QLPosition.findByName("DEV");
        QLAccount.showAccount();
        QLAccount.findByUsernameAndFullName("a", "a");

    }
}
