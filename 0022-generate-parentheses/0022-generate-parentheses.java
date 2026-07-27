class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        genParan(res,n,"",0,0);
        return res;
    }
    private void genParan(List<String> res,int n,String s,int l,int r){
        if(s.length()==2*n){
            res.add(s);
            return;
        }
        if(l<n){
            genParan(res,n,s+'(',l+1,r);
        }
        if(r<l){
            genParan(res,n,s+")",l,r+1);
        }
    }
}