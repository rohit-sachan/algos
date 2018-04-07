import java.util.Arrays;

/**
 * Created by Rohit on 8/19/2017.
 */
public class QuickSortPivotHalfHalf {
    public static void main(String[] args) {
        int[] numbers = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
        //               0  1  2  3   4   5   6  7  8   9
        sortNumbers(numbers);
        System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
    }

    private static void sortNumbers(int[] ints) {
        quickSort(ints,0,ints.length-1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start < end){
            int partitionIdx = partition(arr,start,end);
            quickSort(arr,start,partitionIdx-1);
            quickSort(arr,partitionIdx+1,end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int p_idx = start + (end-start)/ 2;
        if((end- start)==1 && arr[start] <= arr[end])
            return p_idx;
        int pivot = arr[p_idx]; //pivot at middle
        while (start<end){
            if(arr[start] > pivot && arr[end] < pivot){
                swap(arr,start,end);
                start++; end--;
            }
            else if(arr[start] > pivot && arr[end] >= pivot){
                end--;
            }
            else if(arr[start] <= pivot && arr[end] < pivot){
                start++;
            }
            else if(arr[start] < pivot && arr[end]>=pivot){
                start++ ; end--;
            }
        }
        swap(arr,start,p_idx);
        return start;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j] = tmp;
    }
}
