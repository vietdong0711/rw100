package entity;

import enums.GioiTinh;

public class CongNhan extends CanBo {
    private int bac;

    public CongNhan() {

    }

    public CongNhan(int age, String diaChi, String fullName, GioiTinh gioiTinh, int bac) {
        super(age, diaChi, fullName, gioiTinh);
        this.bac = bac;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    @Override
    public String toString() {
        return "==Công nhân== Họ tên: " + super.getFullName() + ", Tuổi: "+ super.getAge() +
                ", Giới tính: " + super.getGioiTinh() + ", Địa chỉ: " + super.getDiaChi() +
                ", Bậc: " + this.bac;
    }
}
