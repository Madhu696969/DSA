class Solution {
    public int countArrangement(int n) {
        HashSet<Integer> hs=new HashSet<>();
        return solve(1,n,hs);
    }
    private int solve(int idx,int n,HashSet<Integer> hs){
        if(idx>n){
            return 1;
        }
        int res=0;
        for(int i=1;i<=n;i++){
            if(hs.contains(i)){
                continue;
            }
            if(idx%i==0 || i%idx==0){
                hs.add(i);
                res+=solve(idx+1,n,hs);
                hs.remove(i);
            }
        }
        return res;
    }
}