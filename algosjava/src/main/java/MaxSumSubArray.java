/**
 * Created by dell on 01/08/17.
 */
import static java.lang.Math.*;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = findmax(arr);
        System.out.println("ans = " + ans);

        int[] ints = findmaxsubArrIdx(arr);
        System.out.println("ints = " + ints[0] + ", " + ints[1]);
    }

    // sum + a[i], a[i]
    private static int findmax(int[] arr) {
        int max_sum_so_far = Integer.MIN_VALUE;
        int current_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            current_sum = max(current_sum + arr[i], arr[i]);
            max_sum_so_far = max(max_sum_so_far, current_sum);
        }

        return max_sum_so_far;
    }


    private static int[] findmaxsubArrIdx(int[] arr) {
        int[] idx = new int[2];

        int max_sum_so_far = Integer.MIN_VALUE;
        int current_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (current_sum + arr[i] > arr[i]) {
                current_sum = current_sum + arr[i];
            } else {
                current_sum=arr[i];
                idx[0]=i;
            }
            if(current_sum > max_sum_so_far) {
                max_sum_so_far = current_sum;
                idx[1]=i;
            }
        }
        System.out.println("max_sum_so_far = " + max_sum_so_far);

        return idx;
    }
}