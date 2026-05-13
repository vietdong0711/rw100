package frontend;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException {
        run();
    }

    public static void run() throws ClassNotFoundException {
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Các chức năng liên quan đến department");
            System.out.println("2. Các chức năng liên quan đến position");
            System.out.println("3. Các chức năng liên quan đến account");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    DepartmentFunction.run();
                    break;
                case "2":
                    PositionFunction.run();
                    break;
                case "3":
                    AccountFunction.run();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }


}