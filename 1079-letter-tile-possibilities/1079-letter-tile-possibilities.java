class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq=new int[26];
        for(char ch:tiles.toCharArray()){
            freq[ch-'A']++;
        }
        return solve(freq);
    }   
    private int solve(int[] freq){
        int res=0;
        for(int i=0;i<26;i++){
            if(freq[i]==0){
                continue;
            }
            res++;
            freq[i]--;
            res+=solve(freq);
            freq[i]++;
        }
        return res;
    }
}