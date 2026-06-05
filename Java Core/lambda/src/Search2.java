public class Search2 {
    public static void main(String[] args) {
        // tìm vtri của số 7
        int[] arrs = new int[]{1,2,4,5,6,7,8,9};
        int start = 0;
        int end = arrs.length;
        int midPoint  = -1;
        int search = 1;
        while (start <= end) {
            midPoint = start + (end -start)/2;
            if (arrs[midPoint] == search) {
                System.out.println("gtri = "+ search +" ở vị trí số " + midPoint);
                break;
            } else {
                if (search < arrs[midPoint]) {
                    System.out.println("gtri = "+ search +" ở ben trái vị trí số " + midPoint);
                    end = midPoint -1;
                } else if (arrs[midPoint] < search){
                    System.out.println("gtri = "+ search +" ở ben phải vị trí số " + midPoint);
                    start = midPoint +1;
                }
            }
        }



    }
}
