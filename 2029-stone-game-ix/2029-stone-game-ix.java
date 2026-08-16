class Solution {
    public boolean stoneGameIX(int[] stones) {
        int c1=0,c2=0,c3=0;
        for(int s:stones){
            if(s%3==0){
                c1++;
            }
            else if(s%3==1){
                c2++;
            }
            else{
                c3++;
            }
        }
        if(c1%2==0){
            return c2!=0 && c3!=0;
        }
        return Math.abs(c2-c3)>2;
    }
}