class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        PriorityQueue<Integer> available=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> assigned=new PriorityQueue<>();
        int res=0;
        for(int i=0,k=0;i<nums.length;i++){
            while(!assigned.isEmpty() && assigned.peek()<i){
                assigned.poll();
            }
            while(k<queries.length && queries[k][0]<=i){
                available.add(queries[k++][1]);
            }
            while(assigned.size()<nums[i] && !available.isEmpty() && available.peek()>=i){
                res++;
                assigned.add(available.peek());
                available.poll();
            }
            if(assigned.size()<nums[i]) return -1;
        }
        return queries.length-res;
    }
}