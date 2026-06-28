// 3975. Filter Occupied Intervals

class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> merged=new ArrayList<>();
        for(int[] interval:occupiedIntervals){
            if(merged.isEmpty() || interval[0]>merged.get(merged.size()-1)[1]+1){
                merged.add(new int[]{interval[0],interval[1]});
            }
            else{
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],interval[1]);
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int[] cur:merged){
            int l=cur[0];
            int r=cur[1];

            
            //No Overlap
            if(l>freeEnd || r<freeStart){
                res.add(Arrays.asList(l,r));
                continue;
            }
            //left remaining
            if(l<freeStart){
                res.add(Arrays.asList(l,freeStart-1));
            }
            //right remaining
            if(r>freeEnd){
                res.add(Arrays.asList(freeEnd+1,r));
            }
        }
        return res;
    }
}