class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int[][] sortedTasks=new int[n][3];
        for(int i=0;i<n;i++){
            sortedTasks[i][0]=tasks[i][0];
            sortedTasks[i][1]=tasks[i][1];
            sortedTasks[i][2]=i;
        }
        int[] res=new int[n];
        int i=0;
        Arrays.sort(sortedTasks,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        int idx=0;
        long cur_time=0;
        while(idx<n || !pq.isEmpty()){
            if(pq.isEmpty() && cur_time<sortedTasks[idx][0]){
                cur_time=sortedTasks[idx][0];
            }
            while(idx<n && sortedTasks[idx][0]<=cur_time){
                pq.offer(new int[]{sortedTasks[idx][1],sortedTasks[idx][2]});
                idx++;
            }
            int[] cur=pq.poll();
            int cur_dur=cur[0];
            int cur_idx=cur[1];
            cur_time+=cur_dur;

            res[i++]=cur_idx;
        }
        return res;
    }
}