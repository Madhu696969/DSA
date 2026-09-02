class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int u=pre[1];
            int v=pre[0];
            mp.get(u).add(v);
        }
        int[] vis=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(!dfs(i,mp,vis)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int node,HashMap<Integer,List<Integer>> mp,int[] vis){
        if(vis[node]==1){
            return false;
        }
        if(vis[node]==2){
            return true;
        }
        vis[node]=1;
        for(int nei:mp.get(node)){
            if(!dfs(nei,mp,vis)){
                return false;
            }
        }
        vis[node]=2;
        return true;
    }
}