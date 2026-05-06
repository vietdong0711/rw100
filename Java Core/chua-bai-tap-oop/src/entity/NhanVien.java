package entity;

import enums.GioiTinh;

public class NhanVien extends CanBo {
    private String congViec;

    public NhanVien() {

    }

    public NhanVien(int age, String diaChi, String fullName, GioiTinh gioiTinh, String congViec) {
        super(age, diaChi, fullName, gioiTinh);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    @Override
    public String toString() {
        return "==Nhân viên== Họ tên: " + super.getFullName() + ", Tuổi: "+ super.getAge() +
                ", Giới tính: " + super.getGioiTinh() + ", Địa chỉ: " + super.getDiaChi() +
                ", Công việc: " + this.congViec;
    }
}
