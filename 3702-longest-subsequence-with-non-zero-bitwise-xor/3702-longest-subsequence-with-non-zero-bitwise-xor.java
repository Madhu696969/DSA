class Solution {
    public int longestSubsequence(int[] nums) {
        int cZ=0;
        int tt=0;
        for(int n:nums){
            tt^=n;
            if(n==0) cZ++;
        }
        if(tt!=0) return nums.length;
        else if(cZ==nums.length) return 0;
        else return nums.length-1;
    }
}