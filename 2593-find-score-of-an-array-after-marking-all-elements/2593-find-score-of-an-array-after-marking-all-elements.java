class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{i,nums[i]});
        }
        boolean[] seen=new boolean[nums.length];
        long res=0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            if(!seen[cur[0]]){
                res+=cur[1];
                if(cur[0]-1 >=0){
                    seen[cur[0]-1]=true;
                }
                if(cur[0]+1 <=nums.length-1){
                    seen[cur[0]+1]=true;
                }
                seen[cur[0]]=true;
            }
        }
        return res;
    }
}