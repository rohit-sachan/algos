/*
1 1 2 3 5 8 13
 */
public class FibonacciSeries {
    
    public static void main(String[] args) {
        for (int i = 1; i < 50 ; i++) {
            System.out.printf("%d -> %d, \n",i,find(i));
        }
    }

    private static long find(int i) {
        if(i==1 || i ==2) return 1;
        long r=1, i_2=1, i_1=1;
        for (int j = 3; j <= i ; j++) {
            r= i_2+i_1;
            i_2=i_1;
            i_1=r;
        }
        return r;
    }
}
