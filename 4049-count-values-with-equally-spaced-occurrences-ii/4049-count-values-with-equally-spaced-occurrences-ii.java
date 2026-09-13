class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            mp.putIfAbsent(nums[i],new ArrayList<>());
            mp.get(nums[i]).add(i);
        }
        int res=0;
        for(List<Integer> ls:mp.values()){
            if(ls.size()>=3){
                int g=ls.get(1)-ls.get(0);
                boolean sp=true;
                for(int i=1;i<ls.size()-1;i++){
                    if(ls.get(i+1)-ls.get(i)!=g){
                        sp=false;
                        break;
                    }
                }
                if(sp) res++;
            }
        }
        return res;
    }
}