class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int l=0;
        int res=0;
        for(int r=0;r<s.length();r++){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);

            while(mp.get(s.charAt(r))>2){
                mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0)-1);

                if(mp.getOrDefault(s.charAt(l),0)==0){
                    mp.remove(s.charAt(l));
                }

                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}