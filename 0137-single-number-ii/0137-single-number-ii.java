class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<32;i++){
            int s=0;
            for(int n:nums){
                s+=(n>>i)&1;
            }
            if(s%3!=0){
                res|=(1<<i);
            }
        }
        return res;
    }
}