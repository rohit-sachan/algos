/**
 * Created by Rohit on 8/17/2017.
 */
public class LowestInteger {
    public static void main(String[] args) {
        System.out.println("lowest_2nd = " + findLowest(new int[]{12,4,5,2,7,9}));
        System.out.println("lowest_2nd = " + findLowest(new int[]{2,4,5,3,7,9}));
        System.out.println("lowest_2nd = " + findLowest(new int[]{120,40,5,2,7,9}));


    }

    private static int findLowest(int[] ints) {
        // int create a array of two ints with INTMAX
        int[] min = new int [] {Integer.MAX_VALUE,Integer.MAX_VALUE} ;
        for (int n : ints) {
           if (n<min[0]) { //lower than lowest
               min[1]=min[0];
               min[0]=n;
           }else if (n < min[1] && n> min[0]){ // in between
                min[1] = n;
           }

        }
        return min[1];

    }
}
