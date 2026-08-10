class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->{
            return a[1]-b[1];
        });
        int res=0,end=Integer.MIN_VALUE;
        for(int[] p:pairs){
            if(p[0]>end){
                res++;
                end=p[1];
            }
        }
        return res;
    }
}