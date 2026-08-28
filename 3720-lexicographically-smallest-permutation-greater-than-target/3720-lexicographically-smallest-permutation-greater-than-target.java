class Solution {
    String res="";
    public String lexGreaterPermutation(String s, String target) {
        StringBuilder cur=new StringBuilder();
        int n=s.length();
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        solve(0,target,freq,cur,false); 
        return res;
    }
    private boolean solve(int idx,String t,int[] freq,StringBuilder cur,boolean greater){
        if(idx==t.length()){
            String st=cur.toString();
            
            if(greater){
                res=st;
                return true;
            }
            return false;

        }
        for(int i=0; i<26; i++){
            if(freq[i] == 0){
                continue;
            }
            if(!greater && i<t.charAt(idx)-'a'){
                continue;
            }
            cur.append((char)('a' + i));
            freq[i]--;

            boolean n_g =greater || i>t.charAt(idx) - 'a';
           if(solve(idx+1,t,freq,cur,n_g)){
            return true;
           }
           cur.deleteCharAt(cur.length()-1);
           freq[i]++;
        }
        return false;
    }
}