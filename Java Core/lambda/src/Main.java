import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, 18, "Nguyễn Văn An"));
        students.add(new Student(2, 20, "Trần Bình"));
        students.add(new Student(3, 18, "Lê Văn Cường"));
        students.add(new Student(4, 20, "Dung Do"));
        students.add(new Student(5, 19, "Phạm Thị Hoa"));
        students.add(new Student(6, 19, "Võ Hoàng Khánh"));

        // nhóm các Student có cùng tuổi lại với nhau
        Map<Integer, List<Student>> mapByAge1 = new HashMap<>();
        for (Student s: students) {
            if (mapByAge1.get(s.getAge()) == null) {
                List<Student> list = new ArrayList<>();
                list.add(s);
                mapByAge1.put(s.getAge(), list);
            } else {
                // lấy ra ds theo key
                List<Student> value = mapByAge1.get(s.getAge());
                value.add(s);
            }
        }
        System.out.println("");

        Map<Integer, List<Student>> mapByAge = students.stream().collect(Collectors.groupingBy(i -> i.getAge()));

        // từ students lấy ra 1 map key: name,  value : Student
        Map<String, Student> mapByName = new HashMap<>();
        for (Student s: students) {
            mapByName.put(s.getName(), s);
        }
        Map<String, Student> mapByName2 = students.stream().collect(Collectors.toMap(i -> i.getName(), i -> i));

        System.out.println("");



        // lấy ds các student 18t
//        List<Student> student18 = new ArrayList<>();
//        for (Student s : students) {
//            if (s.getAge() == 18) {// lọc ra các student 18t
//                student18.add(s);
//            }
//        }
//
//        // lambda + stream
//        List<Student> student18s = students.stream().filter(s -> s.getAge() == 18).toList();



        // tìm Student đầu tiên 18t  //1 đối tượng Student

//        Student student18 = new Student();
//        for (Student s : students) {
//            if (s.getAge() == 18) {// lọc ra các student 18t
//                student18 = s;
//                break;
//            }
//        }
//        System.out.println(student18);
//
//        Student s18 = students.stream().filter(s -> s.getAge() == 18).findFirst().get();
//        System.out.println(s18);

//        lấy ds các student 18t và trong tên có chữ "a"
//        List<Student> student18 = new ArrayList<>();
//        for (Student s : students) {
//            if (s.getAge() == 18 && s.getName().toLowerCase().contains("a".toLowerCase())) {// lọc ra các student 18t
//                student18.add(s);
//            }
//        }
//
//        List<Student> student18s = students.stream().filter(s -> s.getAge() == 18 && s.getName().toLowerCase().contains("a".toLowerCase())).toList();


        System.out.println("");


    }
}