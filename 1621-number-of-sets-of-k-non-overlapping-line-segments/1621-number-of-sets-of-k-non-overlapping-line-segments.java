class Solution {
    int mod=1_000_000_007;
    public int numberOfSets(int n, int k) {
        int[][] dp=new int[n+1][k+1];
        int[][] pref=new int[n+1][k+1];
        //base
        for(int i=0;i<n;i++){
            dp[i][0]=1;
            pref[i][0]=i+1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j]=dp[i-1][j];
                dp[i][j]+=pref[i-1][j-1];
                dp[i][j]%=mod;
                pref[i][j]=(pref[i-1][j]+dp[i][j])%mod;
            }
        }
        return dp[n-1][k];
    }
}