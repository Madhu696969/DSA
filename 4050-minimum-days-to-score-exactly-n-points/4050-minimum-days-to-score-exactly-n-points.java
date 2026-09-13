class Solution {
    int[] dp;
    public int minDays(int n) {
        dp=new int[n];
        Arrays.fill(dp,-1);

        return solve(0,n)-1;
    }
    private int solve(int sc,int n){
        if(sc==n){
            return 0;
        }
        if(dp[sc]!=-1){
            return dp[sc];
        }
        int res=Integer.MAX_VALUE;
        for(int k=1;;k++){
            int p=k*(k+1)/2;
            if(sc+p>n){
                break;
            }
            int d=k+1;
            res=Math.min(res,d+solve(sc+p,n));
        }
        return dp[sc]=res;
    }
}