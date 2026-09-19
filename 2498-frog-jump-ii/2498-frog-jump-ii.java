class Solution {
    public int maxJump(int[] stones) {
        int n=stones.length;
        if(n==2){
            return stones[1]-stones[0];
        }
        int low=1,high=stones[n-1]-stones[0]; //max possible distance
        int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid,stones)){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
    private boolean isPossible(int lim,int[] stones){
        for(int i=2;i<stones.length;i++){
            if(stones[i]-stones[i-2]>lim){
                return false;
            }
        }
        return true;
    }
}