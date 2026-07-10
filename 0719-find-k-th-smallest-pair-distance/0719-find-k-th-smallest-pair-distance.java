class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0,h=nums[n-1]-nums[0];
        while(l<h){
            int mid=l+(h-l)/2;
            if(Check(nums,mid)>=k){
                h=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    private int Check(int[] nums,int dis){
        int res=0,l=0;
        for(int r=0;r<nums.length;r++){
            while(nums[r]-nums[l]>dis){
                l++;
            }
            res+=r-l;
        }
        return res;
    }
}