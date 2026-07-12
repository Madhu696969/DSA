class Solution {
    public int maximumCandies(int[] candies, long k) {
        int st=1,end=0;
        for(int candy:candies){
            end=Math.max(candy,end);
        }
        int res=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isPossible(candies,k,mid)){
                res=mid;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return res;
    }
    private boolean isPossible(int[] candies,long k,int mid){
        long res=0;
        for(int candy:candies){
            res+=(candy)/mid;
        }
        return res>=k;
    }
}