public class Main1 {
    public static void main(String[] args) {
        //sắp xếp chọn: chọn dần dần ra gti nhỏ nhất, nhỏ nhì, nhỏ 3, nhỏ 4.....
        int[] arrs = new int[]{9, 4, 1, 3, 5, 7, 2};

        for (int i = 0; i < arrs.length - 1; i++) {
            int indexMin = i;// lưu lại vtri nhỏ nhất
            int min = arrs[i];// luu gtri nhỏ nhất
            for (int j = i + 1; j < arrs.length; j++) {
                if (min > arrs[j]) {
                    indexMin = j;
                    min = arrs[j];
                }
            }
            if (indexMin != i) {
                // đổi chỗ
                int c = arrs[i];
                arrs[i] = arrs[indexMin];
                arrs[indexMin] = c;
            }
        }
        System.out.println("======");
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + " ");
        }



    }


}
