// 1802. Maximum Value at a Given Index in a Bounded Array

class Solution {
    private long getSum(long c,long x){
        return (x*c)-(c*(c+1)/2);
    }
    public int maxValue(int n, int index, int maxSum) {
        int st=1,end=maxSum;
        int res=0;
        while(st<=end){
            long m=st+(end-st)/2;
            //left
            long lc=Math.min((long)index,m-1);
            long lS=getSum(lc,m);
            lS+=Math.max((long)0,index-(m-1)); //extra ones
            //right
            long Rc=Math.min((long)n-index-1,m-1);
            long rS=getSum(Rc,m);
            rS+=Math.max((long)0,n-index-1-(m-1)); //extra ones
            long tt=lS+m+rS;
            if(tt<=maxSum){
                res=(int)Math.max(res,m);
                st=(int)m+1;
            }
            else{
                end=(int)m-1;
            }
        }
        return res;
    }
}