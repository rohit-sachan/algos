import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * Created by Rohit on 8/6/2017.
 */
public class SquareRootOfNumber {

    public static void main(String[] args) {

        System.out.println("root = " + findRoot(9.0d) + " actual root "+ sqrt(9.0d));
        System.out.println("root = " + findRoot(10.0d)+ " actual root "+ sqrt(10.0d));
        System.out.println("root = " + findRoot(16.0d)+ " actual root "+ sqrt(16.0d));

    }

    private static double findRoot(double n) {
        double start =1, end=n, mid=(start+end)/2, pre_mid = 0;

        while (!isAcceptableDiff(mid,n)){ // if difference of mid^2 to n is acceptable then exit
            if(mid* mid == n) return mid;

            if(mid*mid > n){ // generally this is first case because mid*2 is n, not mid^2 is > n
                end = mid;
                mid = (start + end)/2; // new mid is half of previous mid and start
            }else{
                start=mid;
                mid = (start + end)/2; // new mid is half of previous mid and end
            }
        }
        return mid;
    }

    private static boolean isAcceptableDiff(double mid, double n) {
        return abs((mid*mid) - n ) < .0000005;
    }

}
