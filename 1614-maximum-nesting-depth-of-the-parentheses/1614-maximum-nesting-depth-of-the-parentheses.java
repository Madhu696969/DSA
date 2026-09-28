class Solution {
    public int maxDepth(String s) {
        int c=0,res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                res=Math.max(res,c);
                c--;
            }
            else if(s.charAt(i)=='('){
                c++;
            }
        }
        return res;
    }
}