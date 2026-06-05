import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        int[] arrs = new int[]{9, 4, 1, 3, 5, 7, 2}; // 7c
        // sắp xep mang sau theo thu tự tang dần
        for (int i = 0; i < arrs.length - 1; i++) {//6
            int max = arrs[i];
            for (int j = i + 1; j < arrs.length; j++) {
                // nếu arrs[i] <= arrs[j]  giữ ngyên
                if (arrs[i] <= arrs[j]) {
                    max = arrs[j];
                }
                // nếu arrs[i] > arrs[j]  đổi chỗ
                if (arrs[i] > arrs[j]) {// ai = 9   aj= 4
                    // doi chổ cho nhau
                    int c = arrs[i];//9
                    arrs[i] = arrs[j];// ai = 4
                    arrs[j] = c;
                }
            }
        }
        System.out.println("======");
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + " ");
        }
    }
//    List<Integer> arrss = new ArrayList<>();
//    arrss.add(9);
//    arrss.add(4);
//    arrss.add(1);
//    arrss.add(3);
//    arrss.add(5);
//    arrss.add(7);
//    arrss.add(2);
//
//        Collections.sort(arrss);
//        for (int i = 0; i < arrss.size(); i++) {
//            System.out.println(arrss.get(i));
//        }
//
//    }
}
