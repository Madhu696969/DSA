class Solution {
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        int dif=solve(stoneValue,0,n);
        if(dif<0) return "Bob";
        else if(dif >0) return "Alice";
        return "Tie";
    }
    private int solve(int[] stoneValue,int idx,int n){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int res=stoneValue[idx]-solve(stoneValue,idx+1,n);
        if(idx+1 < n){
            res=Math.max(res,stoneValue[idx]+stoneValue[idx+1]-solve(stoneValue,idx+2,n));
        }
        if(idx+2 < n){
            res=Math.max(res,stoneValue[idx]+stoneValue[idx+1]+stoneValue[idx+2]-solve(stoneValue,idx+3,n));
        }
        return dp[idx]=res;
    }
}