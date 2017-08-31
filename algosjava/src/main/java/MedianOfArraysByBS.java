import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.util.Arrays.copyOfRange;

/**
 * Created by Rohit on 8/19/2017.
 */
public class MedianOfArraysByBS {

    public static void main(String[] args) {
        int[] arr1 = new int[]{ 1, 3, 5, 11, 17};
        int[] arr2 = new int[]{9, 10, 11, 13, 14};
        double median = findMedian(arr1,arr2);

        System.out.println("median = " + median);
    }

    private static double findMedian(int[] arr_a, int[] arr_b) {

        if(arr_a.length==2 && arr_b.length ==2){
            return (arr_a[0]+arr_a[1]+arr_b[0]+arr_b[1] - min(arr_a[0],arr_b[0])  - max(arr_a[1],arr_b[1]))/2d;
        }

        double m1 = median(arr_a);
        double m2 = median(arr_b);
        if(m1 == m2) return  m1;

        if(m1<m2){
            int [] arr_a_cp= copyOfRange(arr_a,arr_a.length/2, arr_a.length);
            int [] arr_b_cp= copyOfRange(arr_b,0,(arr_b.length/2)+1);
            return findMedian(arr_a_cp,arr_b_cp);
        }else {
            int [] arr_a_cp = copyOfRange(arr_a, 0, (arr_a.length / 2)+1);
            int [] arr_b_cp = copyOfRange(arr_b, (arr_b.length / 2), arr_b.length);
            return findMedian(arr_a_cp, arr_b_cp);
        }
    }

    private static double median(int[] arr) {
        if (arr.length==0) return 0;
        if(arr.length %2 ==1){
            return arr[arr.length/2];
        }else{
            return (arr[arr.length/2 -1] + arr[(arr.length/2)])/2.0d ;
        }
    }

}
