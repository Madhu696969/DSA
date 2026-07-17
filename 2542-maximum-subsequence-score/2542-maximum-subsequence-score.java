class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=nums1.length;
        int[][] pairs=new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0]=nums2[i];
            pairs[i][1]=nums1[i];
        }
        Arrays.sort(pairs,(a,b)->b[0]-a[0]);
        long s=0,res=0;
        for(int[] p:pairs){
            pq.add(p[1]);
            s+=p[1];
            if(pq.size()>k){
                s-=pq.poll();
            }
            if(pq.size()==k){
                res=Math.max(res,s*p[0]);
            }
        }
        return res;
    }
}