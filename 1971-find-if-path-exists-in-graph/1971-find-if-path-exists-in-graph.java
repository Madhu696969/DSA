class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int v=edge[0];
            int u=edge[1];
            mp.get(v).add(u);
            mp.get(u).add(v);
        }
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> hs=new HashSet<>();
        q.add(source);
        hs.add(source);
        while(!q.isEmpty()){
            int val=q.poll();
            if(val==destination){
                return true;
            }
            for(int ele:mp.get(val)){
                if(!hs.contains(ele)){
                    hs.add(ele);
                    q.add(ele);
                }
            }
        }
        return false;
    }
}