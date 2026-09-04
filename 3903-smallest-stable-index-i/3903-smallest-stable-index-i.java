class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] pref=new int[nums.length];
        int[] suf=new int[nums.length];
        pref[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pref[i]=Math.max(pref[i-1],nums[i]);
        }
        suf[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suf[i]=Math.min(suf[i+1],nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(pref[i]-suf[i]<=k){
                return i;
            }
        }
        return -1;
    }
}