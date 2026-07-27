class Solution {
    public int maxProfit(int[] prices) {
        int res=0,min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            else if(prices[i]-min>0){
                res+=prices[i]-min;
                min=prices[i];
            }
        }
        return res;
    }
}