/**
 * Created by Rohit on 8/6/2017.
 */
public class ReverseString {
    public static void main(String[] args) {
        String str = "This string is";
        System.out.println("reverted = " + revertString(str));
        System.out.println("inPlace reverted words = " + String.valueOf(inPLaceReversal(str)));
    }

    private static String revertString(String str) {
        StringBuffer reverted = new StringBuffer(str.length());
        int last=str.length()-1;
        for(int i = last; i >=0; i--){
            if(str.charAt(i) == ' '){
                reverted.append(str.substring(i+1,last+1)+" ");
                last=i-1;
            }if(i==0){
                reverted.append(str.substring(i,last+1));
            }
        }
        return reverted.toString();
    }


    private static char[] inPLaceReversal(String str) {
        char[] strArr = str.toCharArray();
        int i=0;
        for (int j = 0 ; j < strArr.length; j++){
            char c = strArr[j];
            if(c == ' '){
                strArr = reverse(strArr,i,j-1);
                i=j+1;
            }else if (j==strArr.length-1){
                strArr = reverse(strArr,i,j);
            }
        }
        return strArr;
    }

    private static char[] reverse(char[] str, int m, int n) {
        while (m<=n){
            char t = str[m];
            str[m]= str[n];
            str[n] = t;
            m++; n--;
        }
        return str;
    }
}
