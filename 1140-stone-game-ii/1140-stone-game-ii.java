class Solution {
    int[][][] dp;
    int n;
    public int stoneGameII(int[] piles) {
        n=piles.length;
        dp=new int[2][n][n+1];
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(piles,1,0,1);
    }
    private int solve(int[] piles,int per,int idx,int m){
        if(idx>=piles.length){
            return 0;
        }
        if(dp[per][idx][m]!=-1){
            return dp[per][idx][m];
        }
        int res=(per==1)?-1:Integer.MAX_VALUE;
        int stones=0;
        for(int x=1;x<=Math.min(2*m,n-idx);x++){
            stones+=piles[idx+x-1];
            if(per==1){
                res=Math.max(res,stones+solve(piles,0,idx+x,Math.max(m,x)));
            }
            else{
                res=Math.min(res,solve(piles,1,idx+x,Math.max(m,x)));
            }
        }
        return dp[per][idx][m]=res;
    }
}