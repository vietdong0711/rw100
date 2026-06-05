public class Search1 {

    public static void main(String[] args) {
        // tìm kiếm tuần tự  - ds tăng dần
        int[] arrs = new int[]{1,2,4,5,6,7,8,9};
        // tìm kiém vi trí của phần tử có gtri là 6
        int index = -1;
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] == 6){
                index = i;
                break;
            }
        }
        System.out.println("số 6 nằm ở vtri "+ index);

    }
}
