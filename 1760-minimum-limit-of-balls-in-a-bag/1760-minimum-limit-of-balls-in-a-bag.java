class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int st=1,end=0;
        for(int num:nums){
            end=Math.max(end,num);
        }
        int res=end;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isPossible(nums,maxOperations,mid)){
                res=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return res;
    }
    private boolean isPossible(int[] nums,int maxOperations,int mid){
        int tt=0;
        for(int num:nums){
            int op=(num-1)/mid;
            tt+=op;
            if(tt>maxOperations) return false;
        }
        return tt<=maxOperations;
    }
}