class Solution {
    public String[] largestString(int[] nums) {
        String[] res=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            StringBuilder s=new StringBuilder("z".repeat(val >> 25));
            for(int j=24;j>=0;--j){
                if((1 & (val >> j))==1){
                    s.append((char)('a'+j));
                }
            }
            res[i]=s.toString();
        }
        return res;
    }
}