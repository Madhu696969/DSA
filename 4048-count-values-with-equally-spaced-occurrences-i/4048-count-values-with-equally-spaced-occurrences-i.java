class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            mp.putIfAbsent(nums[i],new ArrayList<>());
            mp.get(nums[i]).add(i);
        }
        int res=0;
        for(List<Integer> ls:mp.values()){
            if(ls.size()==3){
                int fs=ls.get(0);
                int ss=ls.get(1);
                int ts=ls.get(2);
                if(ss-fs==ts-ss){
                    res++;
                }
            }
        }
        return res;
    }
}