// 3974. Maximum Total Sum of K Selected Elements

class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long res=0;
        int n=nums.length;
        for(int i=n-1;i>=n-k;i--){
            if(mul>1){
                res+=1L*nums[i]*mul;
            }
            else{
                res+=nums[i];
            }
            mul--;
        }
        return res;
    }
}