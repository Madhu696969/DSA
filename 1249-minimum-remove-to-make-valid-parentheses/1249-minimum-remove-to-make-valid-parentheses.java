class Solution {
    public String minRemoveToMakeValid(String s) {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        StringBuilder res=new StringBuilder();
        boolean[] v=new boolean[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push(i);
                v[i]=false;
            }
            else if(s.charAt(i)==')'){
                if(!st.isEmpty()){
                    v[i]=false;
                    st.pop();
                }
                else{
                    v[i]=true;
                }
            }
            else{
                v[i]=false;
            }
        }
        while(!st.isEmpty()){
            v[st.pop()]=true;
        }
        for(int i=0;i<n;i++){
            if(!v[i]){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}