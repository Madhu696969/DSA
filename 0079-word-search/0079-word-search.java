class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean res=GetAllPossibleSol(board,word,vis,i,j,0);
                    if(res){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean GetAllPossibleSol(char[][] board, String word,boolean[][] vis,int i,int j,int idx){
        if(idx==word.length()){
            return true;
        }
        if( i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(idx) || vis[i][j]){
            return false;
        }
        vis[i][j]=true;

        // all possible paths for each char
        if(GetAllPossibleSol(board,word,vis,i+1,j,idx+1) || GetAllPossibleSol(board,word,vis,i-1,j,idx+1) || GetAllPossibleSol(board,word,vis,i,j+1,idx+1) || GetAllPossibleSol(board,word,vis,i,j-1,idx+1)){
            return true;
        }
        vis[i][j]=false;
        return false;
    }
}