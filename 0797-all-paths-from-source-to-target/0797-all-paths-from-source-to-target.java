class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        int n=graph.length;
        dfs(graph,0,n-1,res,t);
        return res;
    }
    private void dfs(int[][] graph,int src,int tar,List<List<Integer>> res,List<Integer> t){
        t.add(src);
        if(src==tar){
            res.add(new ArrayList<>(t));
            t.remove(t.size()-1);
            return;
        }
        for(int v:graph[src]){
            dfs(graph,v,tar,res,t);
        }
        t.remove(t.size()-1);
    }
}