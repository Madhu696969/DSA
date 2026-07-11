class Solution {
    HashMap<Integer,List<Integer>> mp=new HashMap<>();
    boolean[] vis;
    public int countCompleteComponents(int n, int[][] edges) {
        for(int[] edge:edges){
            int v=edge[0];
            int u=edge[1];

            mp.putIfAbsent(v,new ArrayList<>());
            mp.putIfAbsent(u,new ArrayList<>());

            mp.get(v).add(u);
            mp.get(u).add(v);
        }
        vis=new boolean[n];
        int res=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
            int[] t=bfs(i);
            int node=t[0];
            int edge=t[1];
            if(node*(node-1)==edge || node==1){
                res++;
            }
            }
        }
        return res;
    }
    private int[] bfs(int node){
        Queue<Integer> q=new LinkedList<>();
        vis[node]=true;
        q.offer(node);
        int nodes=0,edges=0;
        while(!q.isEmpty()){
            int n=q.poll();
            nodes++;
            List<Integer> ls=mp.getOrDefault(n,new ArrayList<>());
            edges+=ls.size();
            for(int val:ls){
                if(!vis[val]){
                    vis[val]=true;
                    q.offer(val);
                }
            }
        }
        return new int[]{nodes,edges};
    }
}