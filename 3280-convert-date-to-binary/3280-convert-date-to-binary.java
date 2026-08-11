class Solution {
    public String convertDateToBinary(String date) {
        int y=Integer.parseInt(date.substring(0,4));
        int m=Integer.parseInt(date.substring(5,7));
        int d=Integer.parseInt(date.substring(8,10));

        String bY=Binary(y);
        String bM=Binary(m);
        String bD=Binary(d);

        return bY+"-"+bM+"-"+bD;
    }

    private String Binary(int n){
        String res="";
        while(n>0){
            int r=n%2;
            res=r+res;
            n/=2;
        }
        return res;
    }
}