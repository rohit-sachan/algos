import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.System.arraycopy;
import static java.util.Arrays.stream;

/**
 * Created by Rohit on 8/19/2017.
 */
public class MedianOfArraysByMerging {

    public static void main(String[] args) {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{2,3};
        double median = findMedian(arr1,arr2);

        System.out.println("median = " + median);
    }

    private static double findMedian(int[] arr_a, int[] arr_b) {
//        int[] arr = merge(arr_a, arr_b);
        Integer [] arr = merge2(arr_a, arr_b);
        stream(arr).forEach((s) -> System.out.print(s + ", "));
        if(arr.length %2 ==1){
            return arr[arr.length/2];
        }else{
            return (arr[arr.length/2 -1] + arr[(arr.length/2)])/2.0d ;
        }


    }

    private static int[] merge(int[] arr_a, int[] arr_b) {
        int[] arr = new int[arr_a.length+arr_b.length];
        int a = 0, b=0;
        while(a < arr_a.length && b < arr_b.length) {
            if(arr_a[a] < arr_b[b]) {
                arr[a+b] = arr_a[a++];
            }else{
                arr[a+b]=arr_b[b++];
            }
        }
        if(a < arr_a.length){
            arraycopy(arr_a, a, arr, a+b, arr_a.length-a);
        }

        if(b < arr_b.length){
            arraycopy(arr_b, b, arr, a+b, arr_b.length-b);
        }
        return arr;
    }

    private static Integer [] merge2(int[] arr_a, int[] arr_b) { //Using arraylist need not to find index
        ArrayList<Integer> arr = new ArrayList<>(arr_a.length+arr_b.length);
        int a = 0, b=0, i=0;
        while(a < arr_a.length && b < arr_b.length) {
            if(arr_a[a] < arr_b[b]) {
                arr.add(arr_a[a]);
                a++;
            }else{
                arr.add(arr_b[b]);
                b++;
            }
        }
        if(a < arr_a.length){
            int[] remainder = Arrays.copyOfRange(arr_a, a, arr_a.length);
            arr.addAll(stream(remainder).boxed().collect(Collectors.toList()));
        }

        if(b < arr_b.length){
            int[] remainder = Arrays.copyOfRange(arr_b, b, arr_b.length);
            arr.addAll(stream(remainder).boxed().collect(Collectors.toList()));
        }
        return arr.toArray(new Integer[arr.size()]);
    }


}
