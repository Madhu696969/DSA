class Solution {
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    int n,m,tt,res=0;

    public int uniquePathsIII(int[][] grid){
        n=grid.length;
        m=grid[0].length;
        int x=0,y=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    tt++;
                }
                else if(grid[i][j]==1){
                    x=i;
                    y=j;
                }
            }
        }
        tt+=1;
        solve(grid,x,y,0);
        return res;
    }
    private void solve(int[][] grid,int i,int j,int c){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==-1){
            return;
        }
        if(grid[i][j]==2){
            if(c==tt){
                res++;
            }
            return;
        }
        grid[i][j]=-1;
        for(int[] d:dir){
            int new_x=i+d[0];
            int new_y=j+d[1];
            solve(grid,new_x,new_y,c+1);
        }
        grid[i][j]=0;
    }

}