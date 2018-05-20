/**
 * Created by Rohit on 5/29/2016.
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int profit =0;
        int last_buy = Integer.MAX_VALUE;
        int mxp_buy = Integer.MAX_VALUE;
        int last_sell = Integer.MIN_VALUE;
        int mxp_sell = Integer.MIN_VALUE;
        for(int p : prices){
            if(p<last_buy){
                last_buy = p;
            }else{
                last_sell = p;
                if((last_sell-last_buy) > profit){
                    profit = last_sell-last_buy;
                    mxp_sell=last_sell;
                    mxp_buy=last_buy;
                }
            }
        }
        System.out.printf("buy %d sell %d\n",mxp_buy, mxp_sell);
        return profit;

    }

    public static void main(String[] args) {
        int price[] = {100, 180, 260, 310, 40, 535, 695, 30, 95};
        System.out.println(maxProfit(price));
    }


}
