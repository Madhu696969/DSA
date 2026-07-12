class Solution {
    public int minCapability(int[] nums, int k) {
        int st=1,end=0;
        for(int num:nums){
            end=Math.max(num,end);
        }
        int res=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isPossible(nums,k,mid)){
                res=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return res;
    }
    private boolean isPossible(int[] nums,int k,int mid){
        int tt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=mid){
                tt++;
                i++;
            }
            if(tt>=k) return true;
        }
        return false;
    }
}