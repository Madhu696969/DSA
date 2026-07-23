class Solution {
    public int totalSteps(int[] nums) {
        Stack<Pair> st=new Stack<>();
        int n=nums.length;
        int res=0;
        st.push(new Pair(nums[n-1],0));
        for(int i=n-2;i>=0;i--){
            int c=0;
            while(!st.isEmpty() && nums[i]>st.peek().val){
                c=Math.max(c+1,st.peek().c);
                st.pop();
            }
            res=Math.max(res,c);
            st.push(new Pair(nums[i],c));
        }
        return res;
    }
}
class Pair{
    int val;
    int c;
    Pair(int val,int c){
        this.val=val;
        this.c=c;
    }
}