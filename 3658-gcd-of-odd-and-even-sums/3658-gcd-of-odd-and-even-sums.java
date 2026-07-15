class Solution {
    public int gcdOfOddEvenSums(int n) {
        int Sodd=n*n;
        int Seven=n*(n+1);
        return gcd(Sodd,Seven);
    }
    private int gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}