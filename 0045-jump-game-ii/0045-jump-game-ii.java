class Solution {
    public int jump(int[] nums) {
        int far=0,res=0,cur=0;
        while(cur<nums.length-1){
            int max=0;
            // Checks If More Efficient Step is skipped while jumping
            for(int i=far;i<=cur;i++){
                max=Math.max(max,nums[i]+i);
            }
            far=cur+1;
            cur=max;
            res++;
        }
        return res;
    }
}