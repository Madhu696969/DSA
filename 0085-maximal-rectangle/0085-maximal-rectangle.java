class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] dp=new int[m];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1')
                    dp[j]++;
                else
                    dp[j]=0;
            }
            int area=calculateArea(dp);
            res=Math.max(res,area);
        }
        return res;
    }
    private int calculateArea(int[] heights){
        int n=heights.length;
        int[] lm=new int[n];
        int[] rm=new int[n];
        Stack<Integer> st=new Stack();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            lm[i]=(!st.isEmpty())?st.peek():-1;
            st.push(i);
        }  
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            rm[i]=!st.isEmpty()?st.peek():n;
            st.push(i);
        }
        int res=0;
        for(int i=0;i<n;i++){
            int w=rm[i]-lm[i]-1;
            int area=w*heights[i];
            res=Math.max(res,area);
        }
        return res;
    }
}