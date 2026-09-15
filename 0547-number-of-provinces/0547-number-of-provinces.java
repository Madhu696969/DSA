class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            mp.putIfAbsent(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    mp.get(i).add(j);
                }
            }
        }
        int res=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,mp);
                res++;
            }
        }
        return res;
    }
    private void dfs(int node,boolean[] vis,HashMap<Integer,List<Integer>> mp){
        vis[node]=true;
        for(int ele:mp.get(node)){
            if(!vis[ele]){
                dfs(ele,vis,mp);
            }
        }
    }
}