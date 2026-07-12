class Solution {
    public int minimumCost(int[] nums, int k) {
        long ini=k;
        int mod=1_000_000_007;
        long res=0;
        long op=0;
        long inv2 = 500000004L;
        for(int i=0;i<nums.length;i++){
            if(ini<nums[i]){
                long need=nums[i]-ini;
                long add=(need+k-1)/k;
                long a=add%mod;
                long b=(2L*(op%mod)+a+1)%mod;
                res=(res+(((a*b)%mod)*inv2)%mod)%mod;
                op+=add;
                ini+=add*(long)k;
            }
            ini-=nums[i];
        }
        return (int)(res);
        
    }
}