// 838. Push Dominoes

class Solution {
    public String pushDominoes(String s) {
        int n=s.length();
        int[] lR=new int[n];
        int[] rL=new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='R'){
                lR[i]=i;
            }
            else if(s.charAt(i)=='.'){
                lR[i]=i>0?lR[i-1]:-1;
            }
            else{
                lR[i]=-1;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='L'){
                rL[i]=i;
            }
            else if(s.charAt(i)=='.'){
                rL[i]=i<n-1?rL[i+1]:-1;
            }
            else{
                rL[i]=-1;
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            int rDis=Math.abs(i-rL[i]);
            int lDis=Math.abs(i-lR[i]);

            if(rL[i]==lR[i]){
                res.append(".");
            }
            else if(rL[i]==-1){
                res.append("R");
            }
            else if(lR[i]==-1){
                res.append("L");
            }
            else if(rDis==lDis){
                res.append(".");
            }
            else{
                if(rDis<lDis)res.append("L");
                else res.append("R");
            }
        }
        return res.toString();
    }
}