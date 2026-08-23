class Solution {
    public boolean sumGame(String num) {
        int lQ=0,rQ=0,lS=0,rS=0;
        int n=num.length();
        for(int i=0;i<n;i++){
            if(num.charAt(i)=='?'){
                if(i < n/2){
                    lQ++;
                }
                else{
                    rQ++;
                }
            }
            else{
                int val=num.charAt(i)-'0';
                if(i<n/2){
                    lS+=val;
                }
                else{
                    rS+=val;
                }
            }
        }
        if((lQ+rQ)%2==1){
            return true;
        }
        return (lS*2+lQ*9!=rS*2+rQ*9);
    }
}