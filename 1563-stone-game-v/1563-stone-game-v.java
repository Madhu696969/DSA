class Solution {
    int[][] dp;
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int[] pSum=new int[n];
        pSum[0]=stoneValue[0];
        for(int i=1;i<n;i++){
            pSum[i]=pSum[i-1]+stoneValue[i];
        }

        return solve(0,n-1,pSum);
    }
    private int solve(int l,int r,int[] pSum){
        if(l>=r){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int res=0;

        for(int m=l;m<=r-1;m++){
            int lS=pSum[m]-((l-1>=0)?pSum[l-1]:0);
            int rS=pSum[r]-pSum[m];

            if(lS>rS){
                res=Math.max(res,rS+solve(m+1,r,pSum));
            }
            else if(lS<rS){
                res=Math.max(res,lS+solve(l,m,pSum));
            }
            else{
                res=Math.max(res,Math.max(lS+solve(l,m,pSum),rS+solve(m+1,r,pSum)));
            }
        }
        return dp[l][r]=res;
    }
}