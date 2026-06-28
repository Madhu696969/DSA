//3020. Find the Maximum Number of Elements in Subset

class Solution {
    public int maximumLength(int[] nums) {
        int res=0;
        HashMap<Long,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            long k=nums[i];
            mp.put(k,mp.getOrDefault(k,0)+1);
        }
        for(long st:mp.keySet()){
            long key=st;
            int tt=0;
            if(key==1){
                int freq=mp.getOrDefault(key,0);
                tt=freq%2==1?freq:freq-1;
            }
            else{
                while(mp.getOrDefault(key,0)>=2 && mp.containsKey(key*key)){
                    tt+=2;
                    key=key*key;
                }
                tt+=1;
            }
            res=Math.max(res,tt);
        }
        return res;
    }
}