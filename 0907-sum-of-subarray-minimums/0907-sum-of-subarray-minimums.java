class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] lm=new int[n];
        int[] rm=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            lm[i]=(!st.isEmpty())?st.peek():-1;
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            rm[i]=(!st.isEmpty())?st.peek():n;
            st.push(i);
        }
        int mod=1_000_000_007;
        int res=0;
        for(int i=0;i<n;i++){
            long ls=i-lm[i];
            long rs=rm[i]-i;
            long ttWays=ls*rs;
            long ttS=ttWays*arr[i];
            res=(int)((res+ttS)%mod);
        }
        return res;
    }
}