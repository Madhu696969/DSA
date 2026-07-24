class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        int[] twoPairXor=new int[2048];
        int[] triPairXor=new int[2048];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                twoPairXor[nums[i]^nums[j]]=1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<2048;j++){
                if(twoPairXor[j]==1){
                    triPairXor[nums[i]^j]=1;
                }
            }
        }
        int res=0;
        for(int val:triPairXor){
            if(val==1){
                res++;
            }
        }
        return res;
    }
}