package backend;

import entity.CanBo;
import entity.CongNhan;
import entity.KySu;
import entity.NhanVien;
import enums.GioiTinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLCB {
//    Thêm mới cán bộ.
//    Tìm kiếm theo họ tên.
//    Hiện thị thông tin về danh sách các cán bộ.
//    Nhập vào tên của cán bộ và delete cán bộ đó
//    Thoát khỏi chương trình.

    public static void qlcb() {
        Scanner scanner = new Scanner(System.in);
        List<CanBo> canBos = new ArrayList<>();// lưu trữ các thông tin về cán bộ
        while (true) {
            System.out.println("=====Mời bạn chọn chức năng=====");
            System.out.println("1. Thêm mới cán bộ.");
            System.out.println("2. Tìm kiếm theo họ tên.");
            System.out.println("3. Hiện thị thông tin về danh sách các cán bộ.");
            System.out.println("4. Nhập vào tên của cán bộ và delete cán bộ đó.");
            System.out.println("5. Thoát khỏi chương trình.");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Chức năng Thêm mới cán bộ.");
                    System.out.println("Nhập họ tên: ");
                    String fullName = scanner.nextLine();
                    System.out.println("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập địa chỉ: ");
                    String diaChi = scanner.nextLine();

                    System.out.println("Nhập giới tính: 1. Nam   2. Nữ   Khác. Khác");
                    String gioiTinhChoose = scanner.nextLine();
                    GioiTinh gioiTinh;

                    switch (gioiTinhChoose) {
                        case "1":
                            gioiTinh = GioiTinh.NAM;
                            break;
                        case "2":
                            gioiTinh = GioiTinh.NU;
                            break;
                        default:
                            gioiTinh = GioiTinh.KHAC;
                    }

                    System.out.println("=====Mời bạn chọn cán bộ=====");
                    System.out.println("1. Công nhân.");//bac
                    System.out.println("2. Kỹ sư.");// ngành
                    System.out.println("Khác. Nhân viên.");// công việc
                    String canBoChoose = scanner.nextLine();
                    switch (canBoChoose) {
                        case "1":
                            System.out.println("Nhập bậc: ");
                            int bac = scanner.nextInt();
                            scanner.nextLine();
                            CanBo congNhan = new CongNhan(age, diaChi, fullName, gioiTinh, bac);

                            canBos.add(congNhan);
                            System.out.println("Đã tạo công nhân thành công!!");
                            break;
                        case "2":
                            System.out.println("Nhập ngành: ");
                            String nganh = scanner.nextLine();
                            CanBo kySu = new KySu(age, diaChi, fullName, gioiTinh, nganh);

                            canBos.add(kySu);
                            System.out.println("Đã tạo kỹ sư thành công!!");
                            break;
                        default:
                            System.out.println("Nhập công việc: ");
                            String congViec = scanner.nextLine();
                            CanBo nhanVien = new NhanVien(age, diaChi, fullName, gioiTinh, congViec);

                            canBos.add(nhanVien);
                            System.out.println("Đã tạo nhân viên thành công!!");
                    }
                    System.out.println("======================");
                    break;
                case "2":
                    System.out.println("Chức năng Tìm kiếm theo họ tên.");
                    System.out.println("Nhập tên cần tìm");
                    String name = scanner.nextLine();
                    System.out.println("======================");
                    boolean checkExists = false;
                    for (CanBo canBo : canBos) {
                        if (canBo.getFullName().equals(name)) {
                            System.out.println(canBo);
                            checkExists = true;
                        }
                    }

//                    canBos.stream().filter( i -> i.getFullName().equals(name));
//                    System.out.println(canBos);

                    if (!checkExists) { //checkExists == false
                        System.out.println("Tên này ko có trong hệ thống!!");
                    }
                    System.out.println("======================");
                    break;
                case "3":
                    System.out.println("Chức năng Hiện thị thông tin về danh sách các cán bộ.");
                    for (CanBo cb: canBos) {
                        System.out.println(cb.toString());
                    }
                    System.out.println("======================");
                    break;
                case "4":
                    System.out.println("Chức năng Nhập vào tên của cán bộ và delete cán bộ đó.");
                    System.out.println("Nhập tên cần xóa");
                    String deleteName = scanner.nextLine();

                    // xóa cán bộ có tên vừa nhập ra khỏi ds
                    List<CanBo> deletes = new ArrayList<>();// ds các cán bộ sẽ bị xóa
                    for (CanBo canBo : canBos) {
                        if (canBo.getFullName().equals(deleteName)) {
                            deletes.add(canBo);
                        }
                    }// sau khi chạy xong for thì sẽ có ds cần xóa
                    // xóa ds đi
                    boolean checkDelete = canBos.removeAll(deletes);

//                    canBos.removeIf(i -> i.getFullName().equals(deleteName));
                    if (checkDelete) {//checkDelete == true
                        System.out.println("Xóa thành công!!");
                    } else {
                        System.out.println("Tên này không tồn tại trong hệ thống!!");
                    }
                    System.out.println("======================");
                    break;
                case "5":
                    System.out.println("Thoát khỏi chương trình.");
                    return;
                default:
                    System.out.println("Mời bạn nhập lại!!!");
            }
        }
    }
}
