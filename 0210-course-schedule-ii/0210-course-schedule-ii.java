class Solution {
    public int[] findOrder(int numC, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<numC;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int u=pre[1];
            int v=pre[0];
            mp.get(u).add(v);
        }
        int[] vis=new int[numC];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<numC;i++){
            if(vis[i]==0){
                if(!dfs(i,mp,vis,st)){
                    return new int[]{};
                }
            }
        }
        int[] res=new int[st.size()];
        for(int i=0;i<res.length;i++){
            res[i]=st.pop();
        }
        return res;
    }
    private boolean dfs(int node,HashMap<Integer,List<Integer>> mp,int[] vis,Stack<Integer> st){
        if(vis[node]==1){
            return false;
        }
        if(vis[node]==2){
            return true;
        }
        vis[node]=1;
        for(int nei:mp.get(node)){
            if(!dfs(nei,mp,vis,st)){
                return false;
            }
        }
        vis[node]=2;
        st.push(node);
        return true;
    }
}