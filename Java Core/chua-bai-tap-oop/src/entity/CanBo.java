package entity;

import enums.GioiTinh;

public class CanBo {
    //    Họ tên, tuổi, giới tính(name, nữ, khác), địa chỉ.
    private String fullName;
    private int age;
    private GioiTinh gioiTinh;
    private String diaChi;

    public CanBo() {

    }

    public CanBo(int age, String diaChi, String fullName, GioiTinh gioiTinh) {
        this.age = age;
        this.diaChi = diaChi;
        this.fullName = fullName;
        this.gioiTinh = gioiTinh;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "age=" + age +
                ", fullName='" + fullName + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
