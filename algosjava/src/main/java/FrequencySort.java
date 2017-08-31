import java.util.Arrays;

/**
 * Created by Rohit on 6/1/2016.
 */
public class FrequencySort {
    public static void main(String[] args) {
        int [] a = {3, 4, 3, 4, 2, 1, 3, 4, 2, 4};
        Arrays.sort(a);

        int [][] freq = new int [a.length][2];
        int j = 0;
        freq[j][0]=a[0];
        freq[j][1]=1;
        for(int i = 1 ; i < a.length ; i++){
            if(a[i] == a[i-1]){
                freq[j][1]++;
            }else{
                j++;
                freq[j][0]=a[i];
                freq[j][1]=1;
            }
        }
        System.out.println(Arrays.toString(freq));

    }

}
