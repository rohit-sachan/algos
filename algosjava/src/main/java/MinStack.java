import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by Rohit on 5/29/2016.
 */
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    private void push(int i) {
        stack.push(i);
        if(min.isEmpty() || min.peek() >= i){
            min.push(i);
        }
    }

    private Integer top() {
        return stack.peek();
    }

    private void pop() {
        Integer pop = stack.pop();
        if(!min.isEmpty() && Objects.equals(min.peek(), pop)){
            min.pop();
        }
    }

    private Integer getMin() {
        return min.peek();
    }

    public static void main(String[] args) throws FileNotFoundException {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }


}
