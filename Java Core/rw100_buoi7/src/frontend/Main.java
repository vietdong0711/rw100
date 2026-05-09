package frontend;

import backend.QLDepartment;
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
        QLDepartment.findByNameAndId("Sale", 2);

    }
}
