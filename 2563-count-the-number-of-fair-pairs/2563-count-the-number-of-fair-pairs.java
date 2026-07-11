class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res=0;
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            int min=lower-nums[i];
            int max=upper-nums[i];
            int low=LowerBound(i+1,n,nums,min);
            int high=UpperBound(i+1,n,nums,max);
            res+=(high-low);
        }
        return res;
    }
    private int LowerBound(int st,int end,int[] nums,int tar){
        int lo=st,hi=end;
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<tar){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return lo;
    } 
    private int UpperBound(int st,int end,int[] nums,int tar){
        int lo=st,hi=end;
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<=tar){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return lo;
    } 
}