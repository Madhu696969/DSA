class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> hs=new ArrayList<>();
        int res=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hs.contains(ch)){
                while(hs.contains(ch)){
                    hs.remove(0);
                }
            }
            hs.add(ch);
            res=Math.max(res,hs.size());
        }
        return res;
    }
}