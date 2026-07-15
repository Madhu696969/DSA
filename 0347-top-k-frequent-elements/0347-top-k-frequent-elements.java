class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int n:nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        List<Map.Entry<Integer,Integer>> ls=new ArrayList<>(mp.entrySet());
        Collections.sort(ls,(a,b)->{
            return b.getValue()-a.getValue();
        });
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=ls.get(i).getKey();
        }
        return res;
    }
}