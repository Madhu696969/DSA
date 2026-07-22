class Solution {
    public long maximumSumOfHeights(int[] heights) {
        long res=0;
        int n=heights.length;
        for(int i=0;i<heights.length;i++){
            long s=heights[i];
            int cur=heights[i];
            for(int j=i-1;j>=0;j--){
                cur=Math.min(cur,heights[j]);
                s+=cur;
            }
            cur=heights[i];
            for(int j=i+1;j<n;j++){
                cur=Math.min(cur,heights[j]);
                s+=cur;
            }
            res=Math.max(res,s);
        }
        return res;
    }
}