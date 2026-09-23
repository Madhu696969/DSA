class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int tt=0;
        for(int n:nums){
            tt+=n;
        }
        int rem=tt-x;
        if(rem<0) return -1;
        if(rem==0) return nums.length;
        mp.put(0,-1);
        int res=-1,s=0;
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            int f=s-rem;
            if(mp.containsKey(f)){
                res=Math.max(res,i-mp.get(f));
            }
            if(!mp.containsKey(s)){
                mp.put(s,i);
            }
        }
        return res==-1?-1:nums.length-res;
    }
}