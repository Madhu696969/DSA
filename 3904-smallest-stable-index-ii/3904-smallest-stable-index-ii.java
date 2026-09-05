class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] pref=new int[n];
        int[] suf=new int[n];
        pref[0]=nums[0];
        suf[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            pref[i]=Math.max(pref[i-1],nums[i]);
        }
        for(int j=n-2;j>=0;j--){
            suf[j]=Math.min(suf[j+1],nums[j]);
        }
        for(int i=0;i<n;i++){
            if(pref[i]-suf[i]<=k){
                return i;
            }
        }
        return -1;
    }
}