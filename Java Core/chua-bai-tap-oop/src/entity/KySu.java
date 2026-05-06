package entity;

import enums.GioiTinh;

public class KySu extends CanBo {
    private String nganh;

    public KySu() {

    }

    public KySu(int age, String diaChi, String fullName, GioiTinh gioiTinh, String nganh) {
        super(age, diaChi, fullName, gioiTinh);
        this.nganh = nganh;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    @Override
    public String toString() {
        return "==Kỹ sư== Họ tên: " + super.getFullName() + ", Tuổi: "+ super.getAge() +
                ", Giới tính: " + super.getGioiTinh() + ", Địa chỉ: " + super.getDiaChi() +
                ", Ngành: " + this.nganh;
    }
}
