// 3756. Concatenate Non-Zero Digits and Multiply by Sum II
// You are given a string s of length m consisting of digits. You are also given a 2D integer array queries, where queries[i] = [li, ri].

// For each queries[i], extract the substring s[li..ri]. Then, perform the following:

// Form a new integer x by concatenating all the non-zero digits from the substring in their original order. If there are no non-zero digits, x = 0.
// Let sum be the sum of digits in x. The answer is x * sum.
// Return an array of integers answer where answer[i] is the answer to the ith query.

// Since the answers may be very large, return them modulo 109 + 7.

 

// Example 1:

// Input: s = "10203004", queries = [[0,7],[1,3],[4,6]]

// Output: [12340, 4, 9]

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length();
        int mod=1_000_000_007;
        int[] pow=new int[n+1];
        long[] sD=new long[n];
        long[] nD=new long[n];
        long[] dC=new long[n];
        pow[0]=1;
        for(int i=1;i<=n;i++){
            pow[i]=(int)((1L*pow[i-1]*10)%mod);
        }
        dC[0]=(s.charAt(0)!='0')?1:0;
        for(int i=1;i<n;i++){
            int dig=s.charAt(i)-'0';
            dC[i] = dC[i-1]+((dig!=0)?1:0);
        }
        nD[0]=s.charAt(0)-'0';
        for(int i=1;i<n;i++){
            int dig=s.charAt(i)-'0';
            if(dig!=0){
                nD[i]=(nD[i-1]*10+dig)%mod;
            }
            else{
                nD[i]=nD[i-1];
            }
        }

        sD[0]=s.charAt(0)-'0';
        for(int i=1;i<n;i++){
            int dig=s.charAt(i)-'0';
            sD[i]=(sD[i-1]+dig)%mod;
        }
        int[] res=new int[queries.length];
        int idx=0;
        for(int[] q:queries){
            int l=q[0];
            int r=q[1];
            long sum=sD[r]-((l==0)?0:sD[l-1]);
            long nB=(l==0)?0:nD[l-1];
            int k = (int)(dC[r]-(l==0?0:dC[l-1]));
            long x=(nD[r]-(nB*pow[k]%mod)+mod)%mod;
            res[idx++]=(int)((sum*x)%mod);
        }
        return res;
    }
}