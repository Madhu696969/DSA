class Solution {
    public String removeOuterParentheses(String s) {
        String result="";
        int i,b=0;
        for(i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(b>0){
                    result+=s.charAt(i);
                }
                b++;
            }
            else{
                b--;
                if(b>0){
                    result+=s.charAt(i);
                }
            }
        }
        return result;
    }
}