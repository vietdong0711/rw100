public class Main2 {
    public static void main(String[] args) {
        //sắp xếp chèn:             9, 4, 1, 3, 5, 7, 2
        int[] arrs = new int[]{9, 4, 1, 3, 5, 7, 2};
        for (int i = 0; i < arrs.length; i++) {
            int index = i;
            int newNumber = arrs[i];
            while (index > 0 && arrs[index - 1] > newNumber) {
                int c = arrs[index];
                arrs[index] = arrs[index - 1];
                arrs[index - 1] = c;
                index--;
            }
            arrs[index] = newNumber;
        }

        System.out.println("======");
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + " ");
        }
    }

}
