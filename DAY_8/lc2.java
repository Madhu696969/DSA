// 1870. Minimum Speed to Arrive on Time

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int st=1,r=10000000;
        int res=-1;
        while(st<=r){
            int mid=st+(r-st)/2;

            if(Possible(dist,mid)<=hour){
                res=mid;
                r=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return res;
    }
    private double Possible(int[] dist,int mid){
        double time=0;
        int n=dist.length;
        for(int i=0;i<n-1;i++){
            double t=(double)dist[i]/(double)mid;

            time+=Math.ceil(t);
        }
        time+=(double)dist[n-1]/(double)mid;
        return time;
    }
}