import java.util.Stack;

/**
 * Created by Rohit on 5/29/2016.
 */
public class MatchingBrackets {

    public static boolean isValid(String s){
        Stack<Character> stk = new Stack<>();
        char[] ps = s.toCharArray();
        for(Character c : ps){
            if(c==')' || c=='}' || c==']'  ) {
                if(stk.isEmpty()){
                    return false;
                }else{
                    char last = stk.peek();
                    if((last == '(' && c== ')') ||(last == '{' && c== '}') || (last == '[' && c== ']') ) {
                        stk.pop();
                    }
                    if(stk.isEmpty()){
                        return true;
                    }
                }
            }else{
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((isValid("{[(])}")? "YES" : "NO"));
        System.out.println((isValid("(()((())()))")? "YES" : "NO"));


    }
}
