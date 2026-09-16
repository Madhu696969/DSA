class Solution {
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();

        int n=graph.length;

        for(int i=0;i<n;i++){
            mp.putIfAbsent(i,new ArrayList<>());
            for(int ele:graph[i]){
                mp.get(i).add(ele);
            }
        }
        int[] color=new int[n]; //0->yellow , 1->green , -1 No color
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                color[i] = 0;
                if(!dfs(i,color,mp)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int node,int[] color,HashMap<Integer,List<Integer>> mp){
        for(int ele:mp.get(node)){
            if(color[ele]==color[node]){
                return false;
            }
            if(color[ele]==-1){
                color[ele]=1-color[node];
                if(!dfs(ele,color,mp)){
                    return false;
                }
            }
        }
        return true;
    }
}