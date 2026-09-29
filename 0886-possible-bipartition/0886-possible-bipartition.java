class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();

        for(int i=1;i<=n;i++){
            mp.putIfAbsent(i,new ArrayList<>());
        }
        for(int[] dis:dislikes){
            int u=dis[0];
            int v=dis[1];
            mp.get(u).add(v);
            mp.get(v).add(u);
        }
        int[] color=new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!bfsBipart(color,i,mp)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfsBipart(int[] color,int node,HashMap<Integer,List<Integer>> mp){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=1;

        while(!q.isEmpty()){
            int u=q.poll();

            for(int v:mp.get(u)){
                if(color[v]==color[u]){
                    return false;
                }
                if(color[v]==-1){
                    q.add(v);
                    color[v]=1-color[u];
                }
            }
        }
        return true;
    }
}