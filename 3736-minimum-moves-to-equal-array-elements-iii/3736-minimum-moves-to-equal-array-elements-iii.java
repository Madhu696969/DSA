class Solution {
    public int minMoves(int[] nums) {
        int min=0;
        for(int n:nums){
            min=Math.max(min,n);
        }
        int res=0;
        for(int n:nums){
            res+=min-n;
        }
        return res;
    }
}