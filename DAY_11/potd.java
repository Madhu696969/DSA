// 1288. Remove Covered Intervals

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]) return Integer.compare(b[1],a[1]);

            return Integer.compare(a[0],b[0]);
        });
        int n=intervals.length;
        int[] prev=intervals[0];
        ArrayList<int[]> res=new ArrayList<>();
        for(int i=1;i<n;i++){
            int[] cur=intervals[i];
            if(prev[1]>=cur[1]){
                continue;
            }
            else{
                res.add(prev);
                prev=cur;
            }
        }
        res.add(prev);
        return res.size();
    }
}