class Solution {
    int[] dp;
    public boolean winnerSquareGame(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
    private boolean solve(int n){
        if(n==0){
            dp[n]=0;
            return false;
        }
        if(n==1){
            dp[n]=1;
            return true;
        }

        if(dp[n]!=-1){
            return dp[n]==1?true:false;
        }
        int num=(int)Math.sqrt(n);
        if(num*num==n){
            dp[n]=1;
            return true;
        }
        for(int i=1;i*i<=n;i++){
            boolean prev=solve(n-i*i);
            if(prev==false){
                dp[n]=1;
                return true;
            }
        }
        dp[n]=0;
        return false;
    }
}