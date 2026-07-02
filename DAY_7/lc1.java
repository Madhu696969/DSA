// 2448. Minimum Cost to Make Array Equal

class Solution {
    private long getTotal(int[] nums,int[] cost,long x){
        long res=0;
        for(int i=0;i<nums.length;i++){
            res+=Math.abs(nums[i]-x)*cost[i];
        }
        return res;
    }
    public long minCost(int[] nums, int[] cost) {
        long st=1L,end=1000000L;
        for(int n:nums){
            st=Math.min(n,st);
            end=Math.max(n,end);
        }
        long res=getTotal(nums,cost,1);
        while(st<end){
            long mid=(st+end)/2;
            long y1=getTotal(nums,cost,mid);
            long y2=getTotal(nums,cost,mid+1);
            res=Math.min(y1,y2);
            if(y1<y2){
                end=mid;
            }
            else{
                st=mid+1;
            }
        }
        return res;
    }
}