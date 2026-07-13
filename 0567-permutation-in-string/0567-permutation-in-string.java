class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m) return false;
        int[] freqS1=new int[26];
        int[] freqS2=new int[26];
        for(int i=0;i<n;i++){
            freqS1[s1.charAt(i)-'a']++;
        }
        int j=0,i=0;
        while(j<m){
            freqS2[s2.charAt(j)-'a']++;
            if(j-i+1>n){
                freqS2[s2.charAt(i)-'a']--;
                i++;
            }
            if(Arrays.equals(freqS1,freqS2)) return true;
            j++;
        }
        return false;
    }
}