class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<int[]>> mp=new HashMap<>();
        for(int i=1;i<=n;i++){
            mp.putIfAbsent(i,new ArrayList<int[]>());
        }
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int w=time[2];
            mp.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        pq.offer(new int[]{0,k});
        dis[k]=0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int d=cur[0];
            int node=cur[1];
            for(int[] adj:mp.get(node)){
                int v=adj[0];
                int w=adj[1];
                if(dis[node]+w < dis[v]){
                    dis[v]=dis[node]+w;
                    pq.offer(new int[]{dis[v],v});
                }
            }
        }
        int min=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
            else{
                min=Math.max(min,dis[i]);
            }
        }
        return min;
    }
}