// 1288. Remove Covered Intervals

// Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.

// The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

// Return the number of remaining intervals.

 

// Example 1:

// Input: intervals = [[1,4],[3,6],[2,8]]
// Output: 2
// Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

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