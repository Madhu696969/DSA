class Solution {
    public long repairCars(int[] ranks, int cars) {
        long st=1;
        int max=0;
        for(int r:ranks){
            max=Math.max(max,r);
        }
        long end=max*(long)Math.pow(cars,2);
        long res=0;
        while(st<=end){
            long mid=st+(end-st)/2;

            if(isPossible(ranks,cars,mid)){
                res=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return res;
    }
    private boolean isPossible(int[] ranks,int cars,long mid){
        int tt=0;
        for(int r:ranks){
            tt+=Math.sqrt(mid/r);
            if(tt>=cars) return true;
        }
        return false;
    }
}