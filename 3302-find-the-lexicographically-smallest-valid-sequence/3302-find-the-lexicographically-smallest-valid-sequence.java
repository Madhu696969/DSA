class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[] suf=new int[n+1];
        int j=m-1;
        for(int i=n-1;i>=0;i--){
            suf[i]=suf[i+1];
            if(j>=0 && word1.charAt(i)==word2.charAt(j)){
                suf[i]++;
                j--;
            }
        }
        int[] res=new int[m];
        boolean canChange=false;
        j=0;
        for(int i=0;i<n && j<m;i++){
            if(word1.charAt(i)==word2.charAt(j)){
                res[j]=i;
                j++;
            }
            else if(!canChange){
                int rem=m-j-1;
                if(suf[i+1]>=rem){
                    res[j]=i;
                    j++;
                    canChange=true;
                }
            }
        }
        if(j!=m) return new int[]{};
        return res;
    }

}