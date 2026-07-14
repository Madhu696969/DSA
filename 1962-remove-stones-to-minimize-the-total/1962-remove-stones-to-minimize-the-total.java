class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int tt=0;
        for(int pile:piles){
            tt+=pile;
            pq.offer(pile);
        }
        while(k-- >0){
            int pile=pq.poll();
            pq.offer(pile-pile/2);
            tt-=pile/2;
        }
        return tt;
    }
}