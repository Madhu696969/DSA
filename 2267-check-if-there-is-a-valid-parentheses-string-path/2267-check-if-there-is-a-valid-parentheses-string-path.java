class Solution {
    int n,m;
    int[][][] memo;
    public boolean hasValidPath(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        memo=new int[n][m][n+m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        if((n+m-1)%2!=0){
            return false;
        }
        if(grid[0][0]==')' || grid[n-1][m-1]=='('){
            return false;
        }
        return dfs(grid,0,0,0);
    }
    private boolean dfs(char[][] grid,int i,int j,int c){
        if(i>=n || j>=m){
            return false;
        }
        if(grid[i][j]=='('){
            c++;
        }
        else{
            c--;
        }
        if(c<0){
            return false;
        }
        if(memo[i][j][c]!=-1){
            return memo[i][j][c]==1;
        }
        if(i==n-1 && j==m-1){
            memo[i][j][c]=(c==0?1:0);
            return memo[i][j][c]==1;
        }
        boolean r=dfs(grid,i+1,j,c);
        boolean d=dfs(grid,i,j+1,c);
        memo[i][j][c]=(d||r)?1:0;
        return memo[i][j][c]==1;
    }
}