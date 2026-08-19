class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0,r=0;
        for(int ele:nums){
            r+=ele;
            l=Math.max(ele,l);
        }
        int res=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(nums,mid)<=k){
                res=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    private int isPossible(int[] nums,int cur){
        int c=1,s=0;
        for(int i=0;i<nums.length;i++){
            if(s+nums[i]>cur){
                c++;
                s=nums[i];
            }
            else{
                s+=nums[i];
            }
        }
        return c;
    }
}