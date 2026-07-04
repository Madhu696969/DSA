
// 2492. Minimum Score of a Path Between Two Cities

class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r:roads){
            int ed=r[0];
            int nei=r[1];
            int wt=r[2];
            adj.get(ed).add(new int[]{nei,wt});
            adj.get(nei).add(new int[]{ed,wt});
        }
        boolean[] vis=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        vis[1]=true;
        int res=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int[] edge:adj.get(node)){
                int nei=edge[0];
                int wt=edge[1];
                res=Math.min(res,wt);
                if(!vis[nei]){
                    q.add(nei);
                    vis[nei]=true;
                }
            }
        }
        return res;
    }
}
