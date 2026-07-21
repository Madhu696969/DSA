class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int[] lsv=new int[n];
        int[] rsv=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            lsv[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            rsv[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int w=rsv[i]-lsv[i]-1;
            int area=w*heights[i];
            res=Math.max(res,area);
        }
        return res;
    }
}