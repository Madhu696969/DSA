class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int ele:nums){
            if(pq.size()<2){
                pq.add(ele);
            }
            else{
                if(pq.peek()<ele){
                    pq.poll();
                    pq.add(ele);
                }
            }
        }

        return (pq.poll()-1)*(pq.poll()-1);
    }
}