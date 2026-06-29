// 1967. Number of Strings That Appear as Substrings in Word

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res=0;
        for(String p:patterns){
            if(word.contains(p)){
                res++;
            }
        }
        return res;
    }
}