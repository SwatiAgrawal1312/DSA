class Solution {
    public int maxProfit(int[] prices) {
        //swati agrawal
        int maxprofit=0;
        int buy_price=prices[0];
        int curr_profit=0;
        for(int i=1;i<prices.length;i++){
            if(buy_price>prices[i]){
                buy_price=prices[i];
            }
            else{
                curr_profit=prices[i]-buy_price;
                maxprofit=Math.max(maxprofit,curr_profit);

            }
        }
        return maxprofit;
        
    }
}