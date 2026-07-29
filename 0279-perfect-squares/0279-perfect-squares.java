class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        return backtrack(n,dp);
    }
    private int backtrack(int n,int[] dp){
        if(n<4){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int ans=n;
        for(int i=1;i*i<=n;i++){
            int sq=i*i;
            ans=Math.min(ans,1+backtrack(n-sq,dp));
        }
        return dp[n]=ans;
    }

}