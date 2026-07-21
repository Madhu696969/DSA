class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int asteroid:asteroids){
            boolean dis=false;
            while(!st.isEmpty() && st.peek()>0 && asteroid<0){
                if(st.peek()==-asteroid){
                    st.pop();
                    dis=true;
                    break;
                }
                else if(st.peek()< -asteroid){
                    st.pop();
                }
                else{
                    dis=true;
                    break;
                }
            }
            if(!dis) st.push(asteroid);
        }
        int[] res=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            res[i]=st.pop();
        }
        return res;
    }
}