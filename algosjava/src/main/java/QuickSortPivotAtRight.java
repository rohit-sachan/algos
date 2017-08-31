
/**
 * Created by Rohit on 8/19/2017.
 */
public class QuickSortPivotAtRight {
    public static void main(String[] args) {
        int[] numbers = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
        sortNumbers(numbers);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
    }

    private static void sortNumbers(int[] ints) {
        quickSort(ints,0,ints.length-1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start < end){
            int partitionIdx = partition_end(arr,start,end);
            quickSort(arr,start,partitionIdx-1);
            quickSort(arr,partitionIdx+1,end);
        }
    }


    private static int partition_end(int[] arr, int start, int end) {
        int pivot = arr[end]; //pivot at end
        int pIdx = start; //this pIdx will be adjusted so that pivot at right place after swap in last
        while (start < end){
            if(arr[start] < pivot){ //if element is smaller than pivot
                swap(arr,start,pIdx); // swap it to lower side of pivot wall
                pIdx++;// increasing pidx at this moment serves two purposes (holds the next value which is higher than pivot) and an adjusting wall.
            }
            start++;
        }
        swap(arr,pIdx, start);// 'start' is now at 'end' so swap 'pivot' with adjusted pIdx with 'pivot'
        return pIdx;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j] = tmp;
    }
}
