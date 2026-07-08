// 1608. Special Array With X Elements Greater Than or Equal X

// You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.

// Notice that x does not have to be an element in nums.

// Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.

 

// Example 1:

// Input: nums = [3,5]
// Output: 2
// Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.

class Solution {
    public int specialArray(int[] nums) {
        int st=1,end=0;
        for(int n:nums){
            end=Math.max(end,n);
        }
        int res=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            int c=0;
            for(int n:nums){
                if(n>=mid) c++;
            }
            if(c==mid){
                return mid;
            }
            if(c>mid){
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}