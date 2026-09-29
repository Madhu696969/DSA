class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            mp.get(u).add(v);
            mp.get(v).add(u);
        }
        return dfs(0,-1,mp,hasApple);
    }
    private int dfs(int node,int par,HashMap<Integer,List<Integer>> mp,List<Boolean> hP){
        int time=0;
        for(int v:mp.get(node)){
            if(v==par) continue;
            int t_child=dfs(v,node,mp,hP);
            if(t_child>0 || hP.get(v)){
                time+=2+t_child;
            }
        }
        return time;
    }
}