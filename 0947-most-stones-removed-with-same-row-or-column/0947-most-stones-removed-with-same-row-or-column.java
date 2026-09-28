class Solution {
    private void dfs(int idx,boolean[] vis,int[][] stones){
        vis[idx]=true;

        for(int i=0;i<stones.length;i++){
            int r=stones[idx][0];
            int c=stones[idx][1];
            if(!vis[i] && (stones[i][0]==r || stones[i][1]==c)){
                dfs(i,vis,stones);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        boolean[] vis=new boolean[n];
        int group=0;
        for(int i=0;i<n;i++){
            if(vis[i]==true) continue;

            dfs(i,vis,stones);
            group++;
        } 
        return n-group;
    }
}