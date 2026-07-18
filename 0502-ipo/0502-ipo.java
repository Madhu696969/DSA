class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int[][] pairs=new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0]=capital[i];
            pairs[i][1]=profits[i];
        }

        Arrays.sort(pairs,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        while(k-- > 0){
            while(i<n && pairs[i][0]<=w){
                pq.add(pairs[i][1]);
                i++;
            }
            if(!pq.isEmpty()){
                w+=pq.peek();
                pq.poll();
            }
        }
        return w;
    }
}