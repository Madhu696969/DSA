class Solution {
    int m,res=Integer.MIN_VALUE;
    public int maximumRequests(int n, int[][] requests) {
        int[] Base=new int[n];
        m=requests.length;
        solve(0,0,Base,requests);
        return res;
    }
    private void solve(int idx,int c,int[] Base,int[][] requests){
        if(idx>=m){
            boolean allZero=true;

            for(int ele:Base){
                if(ele!=0){
                    allZero=false;
                    break;
                }
            }
            if(allZero){
                res=Math.max(res,c);
            }
            return;
        }
        int from=requests[idx][0];
        int to=requests[idx][1];
        Base[from]--;
        Base[to]++;
        solve(idx+1,c+1,Base,requests);
        Base[from]++;
        Base[to]--;
        solve(idx+1,c,Base,requests);
    }
}