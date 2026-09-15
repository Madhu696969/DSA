class Solution {
    public int maxPalindromes(String s, int k) {
        int res=0;
        int cur=0;
        while(cur<s.length()){
            int len=isPalin(s,cur,k);
            if(len==-1){
                cur++;
            }
            else{
                res++;
                cur+=len;
            }
        }
        return res;
    }
    private int isPalin(String s,int cur,int k){
        if(Palin(s,cur,cur+k-1)){
            return k;
        }
        if(Palin(s,cur,cur+k)){
            return k+1;
        }
        return -1;
    }
    private boolean Palin(String s,int st,int end){
        if(end>=s.length() || st>=s.length()){
            return false;
        }
        while(st<=end){
            if(s.charAt(st)!=s.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}