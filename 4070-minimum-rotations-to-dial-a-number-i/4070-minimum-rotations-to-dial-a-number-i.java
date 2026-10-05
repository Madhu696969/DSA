class Solution {
    public int minRotations(String s) {
        int res=0,cur=0;
        for(int i=0;i<s.length();i++){
            int val=s.charAt(i)-'0';
            res+=Math.min(Math.abs(val-cur),10-Math.abs(val-cur));
            cur=val;
        }
        return res;
    }
}