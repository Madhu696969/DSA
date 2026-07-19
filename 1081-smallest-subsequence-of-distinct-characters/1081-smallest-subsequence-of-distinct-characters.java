class Solution {
    public String smallestSubsequence(String s) {
        int[] lst=new int[26];
        for(int i=0;i<s.length();i++){
            lst[s.charAt(i)-'a']=i;
        }
        Stack<Integer> st=new Stack<>();
        boolean[] seen=new boolean[26];
        for(int i=0;i<s.length();i++){
            int t=s.charAt(i)-'a';
            if(seen[t]) continue;
            while(!st.isEmpty() && st.peek()>t && lst[st.peek()]>i){
                seen[st.pop()]=false;
            }
            st.push(t);
            seen[t]=true;
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            res.append((char)(st.pop()+'a'));
        }
        return res.reverse().toString();
    }
}