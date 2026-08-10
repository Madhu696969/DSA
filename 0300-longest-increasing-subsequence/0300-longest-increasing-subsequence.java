class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(res.isEmpty() || res.get(res.size()-1)<nums[i]){
                res.add(nums[i]);
            }
            else{
                int idx=BinaryS(res,nums[i]);
                res.set(idx,nums[i]);
            }
        }
        return res.size();
    }
    private int BinaryS(ArrayList<Integer> res,int tar){
        int l=0,e=res.size()-1;
        while(l<=e){
            int m=l+(e-l)/2;
            if(res.get(m)>=tar){
                e=m-1;
            }
            else{
                l=m+1;
            }
        }
        return l;
    }
}