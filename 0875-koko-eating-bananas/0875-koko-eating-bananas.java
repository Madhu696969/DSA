class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int e=0;
        for(int n:piles){
            e=Math.max(e,n);
        }
        int l=1,res=e;
        while(l<=e){
            int m=l+(e-l)/2;
            if(canEat(piles,m,h)){
                res=m;
                e=m-1;
            }
            else{
                l=m+1;
            }
        }
        return res;
    }
    public boolean canEat(int[] piles,int k,int h){
        long s=0;
        for(int n:piles){
            s+=(n+k-1)/k;
        }
        return s<=h;
    }
}