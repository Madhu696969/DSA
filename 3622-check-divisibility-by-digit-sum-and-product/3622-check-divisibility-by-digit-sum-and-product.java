class Solution {
    public boolean checkDivisibility(int n){
        int ds=0,ps=1;
        int c=n;
        while(c>0){
            int r=c%10;
            ds+=r;
            ps*=r;
            c/=10;
        }
        int tt=ds+ps;
        return n%tt==0;
    }
}