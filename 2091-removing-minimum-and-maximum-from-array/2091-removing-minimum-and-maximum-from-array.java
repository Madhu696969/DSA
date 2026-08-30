class Solution {
    public int minimumDeletions(int[] nums) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,minI=-1,maxI=-1;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                maxI=i;
                max=nums[i];
            }
            if(min>nums[i]){
                minI=i;
                min=nums[i];
            }
        }
        int l=Math.min(minI,maxI);
        int r=Math.max(minI,maxI);
        int BothL=r+1;
        int BothR=nums.length-l;
        int Diff=(l+1)+(nums.length-r);
        return Math.min(BothL,Math.min(BothR,Diff));
    }
}