class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int res=0;
        int n=intervals.length;
        for(int i=0;i<n;i++){
            int st=intervals[i][0];
            int end=intervals[i][1];
            for(int j=i+1;j<n;j++){
                int nst=intervals[j][0];
                int nend=intervals[j][1];
                if(end>=nst && nend>=st){
                    res++;
                }
            }
        }
        return res;
    }
}