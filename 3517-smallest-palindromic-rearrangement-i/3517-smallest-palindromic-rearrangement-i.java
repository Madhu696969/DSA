class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int m=n/2;
        if(n==1 || n==2){
            return s;
        }
        char[] fHalf=s.substring(0,m).toCharArray();
        Arrays.sort(fHalf);
        String f = new String(fHalf);
        StringBuilder res=new StringBuilder(f).reverse();
        if(n%2==1){
            f+=s.charAt(m);
        }
        return f+res.toString();

    }
}