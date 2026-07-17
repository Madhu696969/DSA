class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n=costs.length;
        int i=0,j=n-1;
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>();
        int hired=0;
        long res=0;
        while(hired<k){
            while(pq1.size()<candidates && i<=j){
                pq1.add(costs[i]);
                i++;
            }
            while(pq2.size()<candidates && j>=i){
                pq2.add(costs[j]);
                j--;
            }
            int a=(pq1.size()>0)?pq1.peek():Integer.MAX_VALUE;
            int b=(pq2.size()>0)?pq2.peek():Integer.MAX_VALUE;
            if(a<=b){
                res+=a;
                pq1.poll();
            }
            else{
                res+=b;
                pq2.poll();
            }
            hired++;
        }
        return res;
    }
}