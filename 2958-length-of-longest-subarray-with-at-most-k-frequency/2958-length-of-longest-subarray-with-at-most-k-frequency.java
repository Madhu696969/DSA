class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int l=0,res=0;
        for(int r=0;r<nums.length;r++){
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
            while(mp.getOrDefault(nums[r],0)>k){
                mp.put(nums[l],mp.getOrDefault(nums[l],0)-1);
                if(mp.getOrDefault(nums[l],0)==0){
                    mp.remove(nums[l]);
                }
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}