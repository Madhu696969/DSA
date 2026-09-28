class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q=new LinkedList<>();
        int n=rooms.size();
        boolean[] vis=new boolean[n];
        q.offer(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int val:rooms.get(cur)){
                if(!vis[val]){
                    q.offer(val);
                    vis[val]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
}