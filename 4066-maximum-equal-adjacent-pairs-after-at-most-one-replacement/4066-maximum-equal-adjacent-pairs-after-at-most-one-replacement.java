class Solution {
    private record Key(int a,int b){}
    public int maxEqualAdjacentPairs(int[] nums) {
        int res=0;
        HashMap<Key,Integer> mp=new HashMap<>();
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                res++;
            }
            else{
                Key k;
                if(nums[i]<nums[i-1]){
                    k=new Key(nums[i],nums[i-1]);
                }
                else{
                    k=new Key(nums[i-1],nums[i]);
                }
                mp.put(k,mp.getOrDefault(k,0)+1);
            }
        }
        int best=0;
        for(int val:mp.values()){
            best=Math.max(best,val);
        }
        return res+best;
    }
}