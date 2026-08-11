class Solution {
    public int missingInteger(int[] nums) {
        int max=nums[0];
        int s=0;
        HashSet<Integer> hs=new HashSet<>();
        for(int n:nums){
            hs.add(n);
        }
        for(int i=1;i<nums.length;i++){
            hs.add(nums[i]);
            if(nums[i]==nums[i-1]+1){
                max+=nums[i];
            }
            else{
                break;
            }
        }
        while(hs.contains(max)){
            max++;
        }
        return max;
    }
}