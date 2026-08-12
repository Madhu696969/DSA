class Solution {
    public int findNumbers(int[] nums) {
        int res=0;

        for(int n:nums){
            int val=(int)Math.log10(n)+1;
            if(val%2==0){
                res++;
            }
        }
        return res;
    }
}