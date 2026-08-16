class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int res=0;
        int maxG=0;
        for(int li:lights){
            maxG=Math.max(li,maxG);
        }

        for(int i=0;i<arrivalTime.length;i++){
            int r=arrivalTime[i]%period;
            if(r>=maxG){
                res=Math.max(res,period-r);
            }
        }
        return res;
    }
}