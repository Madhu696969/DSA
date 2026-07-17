class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->b.get(0)-a.get(0));
        int n=nums1.length;
        int m=nums2.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sum=nums1[i]+nums2[j];
                if(pq.size()<k){
                    pq.add(Arrays.asList(sum,i,j));
                }
                else if(pq.peek().get(0)>sum){
                    pq.poll();
                    pq.add(Arrays.asList(sum,i,j));
                }
                else{
                    break;
                }
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        while(!pq.isEmpty()){
            List<Integer> ls=pq.poll();
            int i=ls.get(1);
            int j=ls.get(2);
            res.add(Arrays.asList(nums1[i],nums2[j]));
        }
        return res;
    }
}