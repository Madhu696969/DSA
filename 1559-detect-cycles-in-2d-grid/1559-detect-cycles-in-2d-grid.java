class Solution {
    int n,m;
    int[][] dirs={
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    private boolean isCon(int r,int c,int prev_r,int prev_c,char[][] grid,boolean[][] vis){
        if(vis[r][c]){
            return true;
        }
        vis[r][c]=true;
        for(int[] dir:dirs){
            int new_r=r+dir[0];
            int new_c=c+dir[1];
            if(new_r>=0 && new_r<n && new_c>=0 && new_c<m && grid[new_r][new_c]==grid[r][c]){
                if(new_c==prev_c && new_r==prev_r){
                    continue;
                }
                if(isCon(new_r,new_c,r,c,grid,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && isCon(i,j,-1,-1,grid,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}