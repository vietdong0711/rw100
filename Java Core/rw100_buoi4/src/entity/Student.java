package entity;

public class Student extends Account {

    private String classz;

    public Student() {

    }

    public String getClassz() {
        return classz;
    }

    public void setClassz(String classz) {
        this.classz = classz;
    }

    public void diHoc() {
        System.out.println("Student đang đi học");
    }
}
