class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        int j=0,n=popped.length;
        for(int n1:pushed){
            st.add(n1);
            while(!st.isEmpty() && j<n && st.peek()==popped[j]){
                st.pop();
                j++;
            }
        }
        return j==n;
    }
}