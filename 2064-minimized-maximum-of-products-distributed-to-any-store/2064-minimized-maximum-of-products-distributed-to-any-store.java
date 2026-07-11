class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int end=0,st=1;
        for(int q:quantities){
            end=Math.max(end,q);
        }
        int res=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isPossible(n,quantities,mid)){
                res=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return res;
        
    }
    private boolean isPossible(int n,int[] quantities,int mid){
        int stores=0;
        for(int q:quantities){
            stores+=(q+mid-1)/mid;
            if(stores>n) return false;
        }
        return stores<=n;
    }
}