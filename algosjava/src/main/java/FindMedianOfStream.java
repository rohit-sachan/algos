import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class FindMedianOfStream {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,15,3,5,7,2,8);
        float median = findMedian(numbers.stream());
        System.out.println("median = " + median);
    }

    private static float findMedian(Stream<Integer> nos) {
        PriorityQueue<Integer> mx= new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> mn= new PriorityQueue<>();
        nos.forEach(i -> putInHeaps(i,mx,mn));

        if(mx.size()==mn.size()) return (mx.peek()+mn.peek())/2;
        else return mx.peek();
    }
/*
Idea is to have two heaps,  imagine for a sorted array with even numbers median will be avg of middle two numbers, but how you get these two numbers
have two heaps. Left side with max-heap because in sorted array left number of middle two will be top of that max-heap and right number will be top of min-heap
If array is sorted but as odd numbers then median wil be middle number which is top of max-heap on left.
 */
    private static void putInHeaps(Integer i, PriorityQueue<Integer> mx, PriorityQueue<Integer> mn) {
        if(mx.isEmpty()) {
            mx.offer(i);
            return;
        }
        if(i>mx.peek())
            mn.offer(i);
        else
            mx.offer(i);

        if(mx.size() == mn.size()) return;

        if (mx.size() > mn.size())
            mn.offer(mx.poll());
        else mx.offer(mn.poll());
    }

}
