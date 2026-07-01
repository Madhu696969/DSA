// 1283. Find the Smallest Divisor Given a Threshold

class Solution {
    public int smallestDivisor(int[] nums, int threshold){
        int end=Integer.MIN_VALUE;
        for(int n:nums){
            end=Math.max(end,n);
        }
        int st=1;
        while(st<end){
            int m=st+(end-st)/2;
            int val=Solve(nums,m);
            if(val>threshold){
                st=m+1;
            }
            else{
                end=m;
            }
        }
        return st;
    }
    private int Solve(int[] nums,int div){
        int s=0;
        for(int n:nums){
            s+=(n+div-1)/div;
        }
        return s;
    }
}