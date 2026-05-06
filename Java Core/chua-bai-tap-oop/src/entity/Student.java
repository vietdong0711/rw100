package entity;

public class Student {
    //id, name, hometown, điểm học lực
    private int id;
    private String name;
    private String hometown;
    private float diem;

    public Student() {

    }

    //Tạo constructor cho phép khi khởi tạo mỗi student thì người dùng sẽ nhập vào tên
    // , hometown và có điểm học lực = 0
    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.diem = 0;
    }

    public Student(float diem, String hometown, int id, String name) {
        this.diem = diem;
        this.hometown = hometown;
        this.id = id;
        this.name = name;
    }

    public float getDiem() {
        return diem;
    }

    //Tạo 1 method cho phép set điểm vào
    public void setDiem(float diem) {
        this.diem = diem;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Tạo 1 method cho phép cộng thêm điểm
    public void plusDiem(float n) {
        this.diem += n;
    }

    //Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
    // điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu,
    // nếu điểm > 4.0 và < 6.0 thì sẽ in ra là trung bình,
    // nếu điểm > 6.0 và < 8.0 thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)
    public void showInfor() {
        System.out.println("Họ tên: " + this.name);
        if (this.diem < 4) {
            System.out.println("Học lực: Yếu");
        } else if (this.diem < 6) {
            System.out.println("Học lực: Trung bình");
        } else if (this.diem < 8) {
            System.out.println("Học lực: Khá");
        } else {
            System.out.println("Học lực: Giỏi");
        }
    }
}
