import java.time.LocalDate;


public class Account {
    // đây là các đặc điểm để nhận diện 1 account  -- thuộc tính
    // tương đuong với các column của bảng account
    int id;
    String username;
    String fullname;
    Gender gender;

    LocalDate createDate;
    int age;
    float height;
    float weight;
    float[] points;
    boolean isPassCourse;
    Group[] groups;

    // tạo enum
    public enum Gender {
        MALE, FEMALE, UNKNOWN;
    }


    // đây là các hành động của đối tượng -- phương thức
    public void an() {
        System.out.println("đang ăn");
    }

    public void ngu() {
        System.out.println("đang ngủ");
    }
}
