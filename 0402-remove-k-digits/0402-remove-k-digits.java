class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k){
            return "0";
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                k--;
                st.pop();
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        res.reverse();
        while(res.length()>1 && res.charAt(0)=='0'){
            res.delete(0,1);
        }
        return res.toString();
    }
}