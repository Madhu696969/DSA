class Solution {
    int[] par=new int[26];
    int[] rank=new int[26];
    private int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }
    private void Union(int x,int y){
        int x_par=find(x);
        int y_par=find(y);
        if(x_par==y_par){
            return;
        }
        if(par[x_par]>par[y_par]){
            par[y_par]=x_par;
        }
        else if(par[x_par]<par[y_par]){
            par[x_par]=y_par;
        }
        else{
            par[x_par]=y_par;
            rank[y_par]++;
        }
    }
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++){
            par[i]=i;
        }
        for(String s:equations){
            if(s.charAt(1)=='='){
                int x=s.charAt(0)-'a';
                int y=s.charAt(3)-'a';
                Union(x,y);
            }
        }

        for(String s:equations){
            if(s.charAt(1)=='!'){
                int x=find(s.charAt(0)-'a');
                int y=find(s.charAt(3)-'a');
                if(x==y){
                    return false;
                }
            }
        }
        return true;

    }
}