class Solution {
    public int smallestNumber(int n, int t) {
        int st=n,end=100;
        while(st<=end){
            if(isPossible(st,t)){
                return st;
            }
            st++;
        }
        return st;
    }
    private boolean isPossible(int val,int t){
        int pro=1;
        while(val>0){
            int r=val%10;
            pro*=r;
            val/=10;
        }
        return pro%t==0;
    }
}