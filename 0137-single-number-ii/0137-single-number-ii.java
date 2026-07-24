class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<32;i++){
            int t=(1<<i);
            int oC=0;
            for(int n:nums){
                if((n&t)!=0){
                    oC++;
                }
            }
            if(oC%3==1){
                res=(res|t);
            }
        }
        return res;
    }
}