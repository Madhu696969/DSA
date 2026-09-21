class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] res=new long[k];
        long[] prevC=new long[k];
        for(int i=0;i<nums.length;i++){
            long[] curC=new long[k];
            int curRem=nums[i]%k;
            curC[curRem]++;
            for(int j=0;j<k;j++){
                int newR=(int)((long)j*nums[i]%k);
                curC[newR]+=prevC[j];
            }
            prevC=curC;
            for(int j=0;j<k;j++){
                res[j]+=prevC[j];
            }
        }
        return res;
    }
}