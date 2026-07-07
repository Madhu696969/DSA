// 3754. Concatenate Non-Zero Digits and Multiply by Sum I

// You are given an integer n.

// Form a new integer x by concatenating all the non-zero digits of n in their original order. If there are no non-zero digits, x = 0.

// Let sum be the sum of digits in x.

// Return an integer representing the value of x * sum.

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