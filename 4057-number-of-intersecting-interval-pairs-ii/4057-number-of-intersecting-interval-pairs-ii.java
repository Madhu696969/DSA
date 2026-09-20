class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        long res=0;
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int[] endPos=new int[n];
        for(int i=0;i<n;i++){
            endPos[i]=intervals[i][1];
        }
        Arrays.sort(endPos);
        for(int i=0;i<n;i++){
            int st=intervals[i][0];
            int l=0,end=n-1;
            while(l<end){
                int mid=l+(end-l)/2;
                if(endPos[mid]>=st){
                    end=mid;
                }
                else{
                    l=mid+1;
                }
            }
            res+=i-l;
        }
        return res;
    }
}