// 2187. Minimum Time to Complete Trips

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long res=0;
        long st=Long.MAX_VALUE;
        for(int t:time){
            st=Math.min(st,t);
        }
        long end=st*totalTrips;
        while(st<end){
            long mid=st+(end-st)/2;
            if(Possible(mid,totalTrips,time)){
                end=mid;
            }
            else{
                st=mid+1;
            }
        }
        return st;
    }
    private boolean Possible(long mid,int totalTrips,int[] time){
        long trips=0;
        for(int ti:time){
            trips+=mid/ti;
        }
        return trips>=totalTrips;
    }
}