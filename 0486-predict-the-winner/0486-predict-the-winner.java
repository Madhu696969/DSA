class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        return solve(nums,0,n-1,0,0,true);
    }
    private boolean solve(int[] nums,int l,int r,int s1,int s2,boolean cur){
        if(l>r){
            return s1>=s2;
        }
        boolean w1=false,w2=false;
        if(cur){
            w1=solve(nums,l+1,r,s1+nums[l],s2,!cur);
            w2=solve(nums,l,r-1,s1+nums[r],s2,!cur);

            return w1 || w2;
        }
        else{
            w1=solve(nums,l+1,r,s1,s2+nums[l],!cur);
            w2=solve(nums,l,r-1,s1,s2+nums[r],!cur);
            return w1 && w2;
        }
    }
}