class Solution {
    int[] par;
    int[] rank;
    private int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par[x]);
    }
    private void Union(int a,int b){
        int x=find(a);
        int y=find(b);
        if(x==y){
            return;
        }

        if(rank[x]>rank[y]){
            par[y]=x;
        }
        else if(rank[y]>rank[x]){
            par[x]=y;
        }
        else{
            par[x]=y;
            rank[y]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        int ex=0;
        for(int[] con:connections){
            int x=con[0];
            int y=con[1];
            int x_par=find(x);
            int y_par=find(y);
            if(x_par!=y_par){
                Union(x,y);
            }
            else{
                ex++;
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(find(i)==i){
                res++;
            }
        }
        return (ex>=res-1)?res-1:-1;
    }
}