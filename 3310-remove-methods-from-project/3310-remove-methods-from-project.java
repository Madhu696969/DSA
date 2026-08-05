class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        boolean[] sus=new boolean[n];
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] inv:invocations){
            mp.get(inv[0]).add(inv[1]);
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(k);
        sus[k]=true;
        while(!q.isEmpty()){
            int v=q.poll();
            for(int u:mp.get(v)){
                if(!sus[u]){
                    q.add(u);
                    sus[u]=true;
                }
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!sus[i])res.add(i);
        }
        for(int[] inv:invocations){
            int u=inv[0];
            int v=inv[1];
            if(!sus[u] && sus[v]){
                List<Integer> ls=new ArrayList<>();
                for(int i=0;i<n;i++){
                    ls.add(i);
                }
                return ls;
            }
        }
        return res;
    }
}