class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] freq=new int[26];
        int[] res=new int[n];

        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            mp.get(u).add(v);
            mp.get(v).add(u);
        }
        solve(labels,0,mp,freq,res,-1); 
        return res;
    }
    private void solve(String labels,int cur,HashMap<Integer,List<Integer>> mp,int[] freq,int[] res,int par){
        int prev_freq=freq[labels.charAt(cur)-'a'];
        freq[labels.charAt(cur)-'a']++;
        for(int node:mp.get(cur)){
            if(node==par) continue;
            solve(labels,node,mp,freq,res,cur);
        }
        int cur_freq=freq[labels.charAt(cur)-'a'];
        res[cur]=cur_freq - prev_freq;
    }
}