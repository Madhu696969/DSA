class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        dp=new int[n][m];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(0,0,s,t);
    }
    private int solve(int i,int j,String s,String t){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int res=0;
        if(s.charAt(i)==t.charAt(j)){
            //take
            res+=solve(i+1,j+1,s,t);
            //Ntake
            res+=solve(i+1,j,s,t);
        }
        else{
            res+=solve(i+1,j,s,t);
        }
        return dp[i][j]=res;
    }
}