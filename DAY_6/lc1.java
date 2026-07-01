// 2187. Minimum Time to Complete Trips

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxW=-1,ttW=0;
        for(int i=0;i<weights.length;i++){
            maxW=Math.max(maxW,weights[i]);
            ttW+=weights[i];
        }
        int l=maxW,r=ttW;
        while(l<r){
            int m=l+(r-l)/2;
            int Curdays=1,tt=0;
            for(int w:weights){
                if(w+tt>m){
                    Curdays++;
                    tt=0;
                }
                tt+=w;
            }
            if(Curdays>days){
                l=m+1;
            }
            else{
                r=m;
            }
        }
        return l;
    }
}