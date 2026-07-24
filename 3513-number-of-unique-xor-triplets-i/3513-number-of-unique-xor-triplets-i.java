class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int res=0;
        for(int ele:nums){
            //Dry Run (Possible ans is next 2^(max ele))
            res|=ele; 
        }
        return res+1;
    }
}