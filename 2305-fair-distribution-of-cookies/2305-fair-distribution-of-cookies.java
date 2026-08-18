class Solution {
    int res=Integer.MAX_VALUE;
    int n;
    public int distributeCookies(int[] cookies, int k) {
        n=cookies.length;
        int[] cok=new int[k];
        solve(0,cookies,cok,k);
        return res;
    }
    private void solve(int idx,int[] cookies,int[] cok,int k){
        if(idx>=n){
            int max=0;
            for(int n1:cok){
                max=Math.max(max,n1);
            }
            res=Math.min(res,max);
            return;
        }
        int cur=cookies[idx];
        for(int i=0;i<k;i++){
            cok[i]+=cur;
            solve(idx+1,cookies,cok,k);
            cok[i]-=cur;
        }
    }
}