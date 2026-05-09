package entity;

public class Department {
    // thuộc tính - đặc điểm
    private int departmentID;//department_id            int
    private String departmentName;//department_name     VARCHAR

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
