class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        solve(0,0,res,new StringBuilder(),n);
        return res;
    }
    private void solve(int op,int clo,List<String> res,StringBuilder sb,int n){
        if(op==n && clo==n){
            res.add(sb.toString());
            return;
        }
        if(op<n){
            solve(op+1,clo,res,sb.append("("),n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(clo<op){
            solve(op,clo+1,res,sb.append(")"),n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}