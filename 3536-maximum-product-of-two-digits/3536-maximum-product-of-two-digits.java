class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        while(n>0){
            int r=n%10;
            if(pq.size()<2){
                pq.add(r);
            }
            else{
                if(pq.peek()<r){
                    pq.poll();
                    pq.add(r);
                }
            }
            n/=10;
        }
        int x1=pq.poll();
        int x2=pq.poll();
        return x1*x2;
    }
}