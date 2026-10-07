class Solution {
    HashSet<String> hs=new HashSet<>();
    int maxLen=0;
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        solve(s,0,0,sb);
        return new ArrayList<>(hs);
    }
    private void solve(String s,int idx,int c,StringBuilder sb){
        if(c<0){
            return;
        }
        if(idx==s.length()){
            if(c==0){
                if(sb.length()>maxLen){
                    maxLen=sb.length();
                    hs.clear();
                }

                if(sb.length()==maxLen){
                    hs.add(sb.toString());
                }
            }
            return;
        }
        char ch=s.charAt(idx);
        if(ch!=')' && ch!='('){
            sb.append(ch);
            solve(s,idx+1,c,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append(ch);
            solve(s,idx+1,c+(ch=='('?1:-1),sb);
            sb.deleteCharAt(sb.length()-1);
        }
        solve(s,idx+1,c,sb);
    }
}