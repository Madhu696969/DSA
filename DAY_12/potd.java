// 3754. Concatenate Non-Zero Digits and Multiply by Sum I

class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        String p = String.valueOf(n).replaceAll("0", ""); 
        int sum=0;
        for(int i=0;i<p.length();i++){
            int t=p.charAt(i)-'0';
            sum+=t;
        }
        long r=Long.parseLong(p);
        return (r*sum);
    }
}