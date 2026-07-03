// 1970. Last Day Where You Can Still Cross

class Solution {
    int ROW,COL;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW=row;
        COL=col;
        int s=cells.length;
        int st=0,end=s-1;
        int res=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(canCross(cells,mid)){
                res=mid+1;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return res;
    }
    private boolean canCross(int[][] cells,int mid){
        int[][] grid=new int[ROW][COL];
        for(int i=0;i<=mid;i++){
            int x=cells[i][0]-1;
            int y=cells[i][1]-1;
            grid[x][y]=1;
        }
        for(int j=0;j<COL;j++){
            if(grid[0][j]==0 && BFS(grid,0,j)){
                return true;
            }
        }
        return false;
    }
    private boolean BFS(int[][] grid,int r,int c){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c});
        grid[r][c]=1;
        while(!q.isEmpty()){
            int[] q1=q.poll();
            int r1=q1[0];
            int c1=q1[1];
            if(r1==ROW-1){
                return true;
            }
            for(int[] d:dir){
                int new_r=r1+d[0];
                int new_c=c1+d[1];
                if(new_r>=0 && new_r<ROW && new_c>=0 && new_c<COL && grid[new_r][new_c]==0){
                    q.add(new int[]{new_r,new_c});
                    grid[new_r][new_c]=1;
                }
            }
        }
        return false;
    }
}