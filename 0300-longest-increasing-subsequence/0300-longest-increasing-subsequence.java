class Solution {

    // Can Be solved Using BinarySearch as well 
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(nums,0,n);
    }
    private int solve(int[] nums,int cur_idx,int prev_idx){
        if(cur_idx==nums.length){
            return 0;
        }

        if(dp[cur_idx][prev_idx]!=-1){
            return dp[cur_idx][prev_idx];
        }
        int take=0;
        if(prev_idx==nums.length || nums[cur_idx] > nums[prev_idx]){
            take=1+solve(nums,cur_idx+1,cur_idx);
        }
        int skip=solve(nums,cur_idx+1,prev_idx);
        return dp[cur_idx][prev_idx]=Math.max(take,skip);
    }
}