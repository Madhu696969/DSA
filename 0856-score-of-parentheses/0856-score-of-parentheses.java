class Solution {
    public int scoreOfParentheses(String s) {
        int res=0;
        int dep=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                dep++;
            }
            else{
                dep--;
                if(s.charAt(i-1)=='('){
                    res+=1<<dep;
                }
            }
        }
        return res;
    }
}