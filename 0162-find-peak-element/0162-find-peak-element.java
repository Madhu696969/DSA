class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int st=0,end=n-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(mid+1<n && nums[mid+1]>nums[mid]){
                st=mid+1;
            }
            else if(mid-1>=0 && nums[mid-1]>nums[mid]){
                end=mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}