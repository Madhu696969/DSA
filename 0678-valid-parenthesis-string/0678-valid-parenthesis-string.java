class Solution {
    int[][] memo;
    public boolean checkValidString(String s) {
        int n=s.length();
        memo=new int[n][n+1];
        for(int[] mem:memo){
            Arrays.fill(mem,-1);
        }
        return solve(0,0,s,n);
    }
    private boolean solve(int idx,int op,String s,int n){
        if(idx==n){
            return op==0;
        }
        if(memo[idx][op]!=-1){
            return memo[idx][op]==1;
        }
        boolean val=false;
        if(s.charAt(idx)=='*'){
            val|=solve(idx+1,op+1,s,n);
            val|=solve(idx+1,op,s,n);

            if(op>0){
                val|=solve(idx+1,op-1,s,n);
            }
        }   
        else if(s.charAt(idx)=='('){
            val|=solve(idx+1,op+1,s,n);
        }
        else if(s.charAt(idx)==')'){
            if(op>0) val|=solve(idx+1,op-1,s,n);
        }
        memo[idx][op]=val?1:0;
        return memo[idx][op]==1;
    }
}