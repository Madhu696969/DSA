class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int[] dis1=new int[n];
        int[] dis2=new int[n];
        Arrays.fill(dis1,Integer.MAX_VALUE);
        Arrays.fill(dis2,Integer.MAX_VALUE);

        boolean[] vis1=new boolean[n];
        boolean[] vis2=new boolean[n];

        solve(edges,node1,dis1,vis1);
        solve(edges,node2,dis2,vis2);
        int res=-1,max=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int maxD=Math.max(dis1[i],dis2[i]);
            if(max>maxD){
                res=i;
                max=maxD;
            }
        }
        return res;
    }
    private void solve(int[] edges,int src,int[] dis,boolean[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.offer(src);
        vis[src]=true;
        dis[src]=0;
        while(!q.isEmpty()){
            int u=q.poll();
            int v=edges[u];
            if(v!=-1 && !vis[v]){
                q.offer(v);
                vis[v]=true;
                dis[v]=dis[u]+1;
            }
        }
    }
}