class Solution {
    public long gcdSum(int[] nums) {
        int maxI=nums[0];
        long[] prefG=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            maxI=Math.max(nums[i],maxI);
            prefG[i]=gcd(nums[i],maxI);
        }
        Arrays.sort(prefG);
        int l=0,r=nums.length-1;
        long res=0;
        while(l<r){
            res+=gcd(prefG[l++],prefG[r--]);
        }
        return res;
    }
    private long gcd(long a,long b){
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}