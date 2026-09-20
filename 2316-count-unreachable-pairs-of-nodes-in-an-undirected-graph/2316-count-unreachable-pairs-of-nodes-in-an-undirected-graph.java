class Solution {
    int[] par;
    int[] rank;
    private int find(int x){
        if(x==par[x]){
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
        if(rank[x] > rank[y]){
            par[y]=x;
        }
        else if(rank[y] > rank[x]){
            par[x]=y;
        }
        else{
            par[x]=y;
            rank[y]++;
        }
    }
    public long countPairs(int n, int[][] edges) {
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            Union(u,v);
        }
        int[] freq=new int[n];
        for(int i=0;i<n;i++){
            int pajii=find(i);
            freq[pajii]++;
        }

        long res=0;
        int rem=n;
        for(int ele:freq){
            res+=(long)ele*(rem-ele);
            rem-=ele;
        }
        return res;
        
    }
}