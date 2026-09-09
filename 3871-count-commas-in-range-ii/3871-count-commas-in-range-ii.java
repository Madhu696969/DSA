class Solution {
    public long countCommas(long n) {
        long res=0;
        long st=1000;
        int cms=1;
        while(st<=n){
            long  e=st*1000-1;
            long  c=Math.min(n,e)-st+1;
            if(c>0){
                res+=c*cms;
            }
            if(st>(Long.MAX_VALUE/1000)) break;
            st*=1000;
            cms++;
        }
        return res;
    }
}