class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Arrays.sort(nums);
        Map<Integer,Integer> mp=new TreeMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        int idx=0;
        while(!mp.isEmpty()){
            List<Integer> keys = new ArrayList<>(mp.keySet());
            for(int k:keys){
                res[idx++]=k;
                int c=mp.get(k)-1;
                if(c==0){
                    mp.remove(k);
                }
                else{
                    mp.put(k,c);
                }
            }
        }
        return res;
    }
}