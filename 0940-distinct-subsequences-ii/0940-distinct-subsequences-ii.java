class Solution {
    int mod=1_000_000_007;
    int[] dp;
    public int distinctSubseqII(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0);
    }
    private int solve(String s,int idx){
        if(idx>=s.length()){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        HashSet<Character> hs=new HashSet<>();
        int res=0;
        for(int i=idx;i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                continue;
            }
            hs.add(s.charAt(i));
            res=(1+solve(s,i+1)%mod+res%mod)%mod;
        }
        return dp[idx]=res;
    }
}