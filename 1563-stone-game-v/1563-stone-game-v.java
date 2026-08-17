class Solution {
    int[][] dp=new int[501][501];  
    public int stoneGameV(int[] stoneValue) {
        for(int[] d:dp)
            Arrays.fill(d,-1);
        int n=stoneValue.length;
        int[] prefs=new int[n];
        prefs[0]=stoneValue[0];
        for(int i=1;i<stoneValue.length;i++){
            prefs[i]=prefs[i-1]+stoneValue[i];
        }
        return solve(0,n-1,prefs);
    }
    private int solve(int l,int r,int[] prefs){
        if(l>=r){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int res=0;
        for(int m=l;m<=r-1;m++){
            int lS=prefs[m]-((l-1)>=0?prefs[l-1]:0);
            int rS=prefs[r]-prefs[m];
            if(lS<rS){
                res=Math.max(res,lS+solve(l,m,prefs));
            }
            else if(rS<lS){
                res=Math.max(res,rS+solve(m+1,r,prefs));
            }
            else{
                res=Math.max(res,Math.max(lS+solve(l,m,prefs),rS+solve(m+1,r,prefs)));
            }
        }
        return dp[l][r]=res;
    }
}