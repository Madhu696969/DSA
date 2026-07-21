class Solution {
    public String simplifyPath(String path) {
        String[] comp=path.split("/");
        Stack<String> st=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(String s:comp){
            if(s.equals("") || s.equals(".")){
                continue;
            }
            if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(s);
            }
        }
        while(!st.isEmpty()){
            res.insert(0,"/"+st.pop());
        }
        return res.length()==0?"/":res.toString();
    }
}