public class TrappingRainWater {

    /**

     Input: arr[] = {2, 0, 2}
     Output: 2
     Structure is like below
     | |
     |_|
     We can trap 2 units of water in the middle gap.

     Input: arr[] = {3, 0, 0, 2, 0, 4}
     Output: 10
     Structure is like below
     |
     | |
     | | |
     |__|_|
     We can trap "3*2 units" of water between 3 an 2,
     "1 unit" on top of bar 2 and "3 units" between 2
     and 4. See below diagram also.

     Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
     Output: 6
     |
     | || |
     _|_||_||||||
     Trap "1 unit" between first 1 and 2, "4 units" between
     first 2 and 3 and "1 unit" between second last 1 and last 2
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(getAmountOfWater(arr));
    }

    public static int getAmountOfWater(int[] walls){

        int t = 0, l, u;
        for (int i = 0; i < walls.length; ) {
            if(walls[i]>0){
                l=walls[i];
                int j = i+1;
                for (; j < walls.length; ) {
                    if(walls[j]<=l){
                        j++;
                    }else {
                        break;
                    }
                }
                t=t + calculateWater(i,j, walls);
                i=j;
            }else{
                i++;
            }
        }
        return t;
    }

    private static int calculateWater(int i, int j, int[] walls) {
        System.out.println("Calculating between "+ i + " & " + j);
        return 0;
    }

}
