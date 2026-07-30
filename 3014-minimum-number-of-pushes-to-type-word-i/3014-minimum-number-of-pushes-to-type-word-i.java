class Solution {
    public int minimumPushes(String word) {
        int res=0,c=1,gC=0;
        for(int i=0;i<word.length();i++){
            gC++;
            if(gC<=8){
                res+=c;
            }
            else{
                c++;
                gC=1;
                res+=c;
            }
        }
        return res;
    }
}