class Solution {
    public int maximumGap(String t, String s) {
        int[] lM=new int[t.length()];
        int[] rM=new int[t.length()];
        int j=-1;
        for(int i=0;i<t.length();i++){
            lM[i]=j=s.indexOf(t.charAt(i),j+1);
        }
        j=s.length();
        for(int i=t.length()-1;i>=0;i--){
            rM[i]=j=s.lastIndexOf(t.charAt(i),j-1);
        }
        int res=0;

        for(int i=0;i<rM.length-1;i++){
            res=Math.max(res,rM[i+1]-lM[i]);
        }

        return res;

    }
}