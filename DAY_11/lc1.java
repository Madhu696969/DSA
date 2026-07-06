// 2968. Apply Operations to Maximize Frequency Score

class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        int n=nums.length;
        Arrays.sort(nums);
        long[] pref=new long[n];
        pref[0]=nums[0];
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+nums[i];
        }
        int min=1,max=n;
        int res=0;
        while(min<=max){
            int mid=min+(max-min)/2;
            if(isPossible(mid,nums,k,pref)){
                res=mid;
                min=mid+1;
            }
            else{
                max=mid-1;
            }
        }
        return res;
    }
    private boolean isPossible(int len,int[] nums,long k,long[] pref){
        int i=0,j=len-1;
        while(j<nums.length){
            int mid=(j+i)/2;
            long tar=nums[mid];
            long leftSum = (mid >0?pref[mid - 1] : 0) - (i > 0 ? pref[i - 1] : 0);
            long rightSum = pref[j] - pref[mid];
            long leftCost = (long)(mid-i)*tar-leftSum;
            long rightCost = rightSum -(long)(j - mid)*tar;
            if (leftCost+rightCost<=k)
            return true;
            i++;
            j++;
        }
        return false;
    }
}