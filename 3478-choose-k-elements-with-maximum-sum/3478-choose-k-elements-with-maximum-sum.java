class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int[][] pairs=new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0]=nums1[i];
            pairs[i][1]=i;
        }
        Arrays.sort(pairs,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        HashMap<Integer,Long> mp=new HashMap<>();
        long s=0;
        int j=0;
        for(int i=0;i<n;i++){
            int idx=pairs[i][1];
            while(j<i){
                int prev_idx=pairs[j][1];
                if(pairs[i][0]<=pairs[j][0]) break;
                s+=nums2[prev_idx];
                pq.offer(nums2[prev_idx]);
                while(pq.size()>k){
                    s-=pq.poll();
                }
                j++;
            }
            mp.put(idx,s);
        }
        long[] res=new long[n];
        for(int i=0;i<n;i++){
            res[i]=mp.getOrDefault(i,0L);
        }
        return res;
    }
}