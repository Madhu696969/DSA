class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n=classroom.length;
        int m=classroom[0].length();

        int[][] lit=new int[n][m];
        for(int[] li:lit){
            Arrays.fill(li,-1);
        }
        int litC=0;
        int sr=0,sc=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(classroom[i].charAt(j)=='S'){
                    sr=i;
                    sc=j;
                }
                else if(classroom[i].charAt(j)=='L'){
                    lit[i][j]=litC;
                    litC++;
                }
            }
        }

        int tar=(1<<litC)-1;
        Queue<States> q=new LinkedList<>();
        q.offer(new States(sr,sc,0,energy,0));
        boolean[][][][] vis=new boolean[n][m][energy+1][(1<<litC)];
        vis[sr][sc][0][0]=true;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        while(!q.isEmpty()){
            States cur=q.poll();
            if(cur.bitmask==tar){
                return cur.moves;
            }

            for(int i=0;i<4;i++){
                int nr=cur.r+dr[i];
                int nc=cur.c+dc[i];

                if(nr>=n || nc>=m || nr<0 || nc<0){
                    continue;
                }

                if(classroom[nr].charAt(nc)=='X'){
                    continue;
                }

                if(cur.energy==0){
                    continue;
                }

                int newEn=cur.energy-1;
                if(classroom[nr].charAt(nc)=='R'){
                    newEn=energy;
                }
                int mask=cur.bitmask;
                int id=lit[nr][nc];
                if(id!=-1){
                    mask=(mask) | (1<<id);
                }
                if(vis[nr][nc][newEn][mask]){
                    continue;
                }
                vis[nr][nc][newEn][mask]=true;
                q.offer(new States(nr,nc,cur.moves+1,newEn,mask));
            }
        }
        return -1;
    }
}
class States{
    int r;
    int c;
    int moves;
    int energy;
    int bitmask;
    States(int r,int c,int moves,int energy,int bitmask){
        this.r=r;
        this.c=c;
        this.moves=moves;
        this.energy=energy;
        this.bitmask=bitmask;
    }
}