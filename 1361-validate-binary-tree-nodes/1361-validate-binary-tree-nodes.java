class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.putIfAbsent(i,new ArrayList<>());
            if (leftChild[i] != -1) {
                mp.get(i).add(leftChild[i]);
            }
            if (rightChild[i] != -1) {
                mp.get(i).add(rightChild[i]);
            }
        }
        int[] inDeg=new int[n];
        for(int i=0;i<n;i++){
            for(int ele:mp.get(i)){
                inDeg[ele]++;
                //No Child Has More Than One Parent
                if(inDeg[ele] > 1){
                    return false;
                }
            }
        }
        int root=-1;
        for(int i=0;i<n;i++){
            if(inDeg[i]==0){
                //More Than One Root
                if(root!=-1){
                    return false;
                }
                root=i;
            }
        }
        if(root==-1) return false;
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[n];
        int c=0;
        q.add(root);
        while(!q.isEmpty()){
            int cur=q.poll();
            if(vis[cur]){
                return false;
            }
            vis[cur]=true;
            c++;
            for(int ele:mp.get(cur)){
                if(!vis[ele]){
                    q.offer(ele);
                }
            }
        }
        return c==n;
    }
}