// 2439. Minimize Maximum of Array

class Solution {
    public int minimizeArrayValue(int[] nums) {
        int st=1,end=0;
        for(int n:nums){
            end=Math.max(end,n);
        }
        int res=end;
        while(st<=end){
            int m=st+(end-st)/2;
            if(isValid(Arrays.stream(nums).asLongStream().toArray(),m)){
                res=m;
                end=m-1;
            }
            else{
                st=m+1;
            }
        }
        return res;
    }
    private boolean isValid(long[] nums,int max){
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>max) return false;
            long canInc=max-nums[i];
            nums[i+1]=nums[i+1]-canInc;
        }
        return nums[n-1]<=max;
    }
}