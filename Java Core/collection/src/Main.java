import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Collection<String> collections = new ArrayList<>();
//        collections.add("x");
//        collections.add("y");
//        collections.add("z");
//        System.out.println("===List===");
        List<String> list = new ArrayList<>();
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");

//
//        for (String s: list) {
//            System.out.println(s);
//        }
//        System.out.println("===SET===");
//        Set<String> set = new HashSet<>();
//        set.add("b  a");
//        set.add("a  z");
//        set.add("c  b");
//
//        for (String s: set) {
//            System.out.println(s);
//        }
        // ngăn xếp: giống như hộp viên sủi
        Stack<String> stack = new Stack<>();
//        stack.push("c");
//        stack.push("b");
//        stack.push("a");
//        stack.push("1");

//        stack.pop();// xoa phan tu tren cùng
//
//
//        for (String s: stack) {
//            System.out.println(s);
//        }
//        System.out.println(stack.empty());


        // hàng đợi
//        Queue<String> queue;
//        queue.element()

        Map<Integer, String> students = new HashMap<>();
        students.put(1, "abc");
        students.put(2, "def");
        students.put(3, "gmk");
        students.put(4, "xyz");
//        System.out.println(students.size());
//        System.out.println(students.remove(3));
//        System.out.println(students.remove(3, "gmk"));
//        System.out.println(students.containsKey(10));
//        System.out.println(students.entrySet());
        // map thì ko thể dùng vòng lăp dc
        // chuyển về Set rồi mới dùng for dc.
//        Set<Map.Entry<Integer, String>> sets = students.entrySet();
//        for (Map.Entry<Integer, String> s: sets) {
//            System.out.println(s.getKey()+ "   :   " + s.getValue());
//        }
        String name =  students.get(10);
        System.out.println(name);
        Set<Integer> keys = students.keySet(); // lấy ra Set key








    }
}