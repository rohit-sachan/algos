import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by dell on 30/07/17.
 */
public class RepeatingChar {

    public static void main(String[] args) {
        String str = "thishasaduplicate";
        long start = System.currentTimeMillis();
        int idx = findFirstDupIdx(str);
        System.out.println("idx = " + idx + " in " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        int idx2 = findFirstDupIdx2(str);
        System.out.println("idx2 = " + idx2 + " in " + (System.currentTimeMillis()-start));

    }


    private static int findFirstDupIdx2(String s) {

        int[] countArr  = new int[256];
        for(int i =0 ; i< s.length(); i++){
            countArr[s.charAt(i)]++;
        }
        for(int i =0 ; i< s.length(); i++){
            if(countArr[s.charAt(i)]==1){
                return  i;
            }
        }
        return -1;
    }

    static LinkedHashMap<Character,Integer> charsCount = new LinkedHashMap<>();
    static HashMap<Character,Integer> indexMap = new HashMap<>();
    private static int findFirstDupIdx(String str) {

        for (int i = 0; i< str.length(); i++) {
            if(charsCount.putIfAbsent(str.charAt(i),1) !=null) {
                charsCount.computeIfPresent(str.charAt(i), (character, integer) -> integer + 1);
            }
            indexMap.putIfAbsent(str.charAt(i),i);
        }
        int result =-1;
        for (Character character: charsCount.keySet()) {
            if(charsCount.get(character)==1){
                result = indexMap.get(character);
                break;
            }
        }
        return result;
    }
}
