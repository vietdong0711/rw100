package frontend;

import backend.Exercise2;
import demo.DebitPayment;
import demo.INganHang;
import demo.NganHang;
import demo.TransferPayment;
import entity.Account;
import entity.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        INganHang chuyenKhoan = new DebitPayment();
        chuyenKhoan.pay();
    }
}
