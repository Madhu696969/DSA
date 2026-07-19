class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int n:nums){
            pq.add((long)n);
        }
        int res=0;
        while(pq.size()>=2 && pq.peek()<k){
            res++;
            long x1=pq.poll();
            long x2=pq.poll();
            long cur=Math.min(x1,x2)*2+Math.max(x1,x2);
            pq.add(cur);
        }
        return pq.peek()>=k?res:-1;
    }
}