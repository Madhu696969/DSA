class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        int second=Integer.MIN_VALUE; // Last Value (Which is Smaller Than Middle)
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(second > nums[i]){ // when this statisfies nums[i] < nums[k] < nums[j]
                return true;
            }
            while(!st.isEmpty() && nums[i]>st.peek()){
                second=st.pop(); // Initialise second which are smal than cur
            }
            st.push(nums[i]); //push
        }
        return false;
    }
}