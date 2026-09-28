class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length;
        int m=maze[0].length;
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q=new LinkedList<>();
        q.offer(entrance);
        boolean[][] vis=new boolean[n][m];
        vis[entrance[0]][entrance[1]]=true;
        int lev=0;
        while(!q.isEmpty()){
            int s=q.size();
            while(s-- >0){
                int[] cur=q.poll();
                for(int[] dir:dirs){
                    int n_r=cur[0]+dir[0];
                    int n_c=cur[1]+dir[1];
                    if(n_r>=0 && n_r<n && n_c>=0 && n_c<m && maze[n_r][n_c]=='.' && !vis[n_r][n_c]){
                        if((n_r==0 || n_r==n-1) || (n_c==0 || n_c==m-1)){
                            return lev+1;   
                        }
                        vis[n_r][n_c]=true;
                        q.offer(new int[]{n_r,n_c});
                    }
                }
            }
            lev++; 
        }
        return -1;
    }
}