class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int st=0,end=0;
        for(int b:bloomDay){
            end=Math.max(end,b);
        }
        int res=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(Possible(bloomDay,mid,k)>=m){
                res=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return res;
    }
    private int Possible(int[] bloomDay,int mid,int k){
        int res=0,cc=0;
        for(int b:bloomDay){
            if(b<=mid){
                cc++;
            }
            else{
                cc=0;
            }

            if(cc==k){
                res++;
                cc=0;
            }
        }
        return res;
    }
}