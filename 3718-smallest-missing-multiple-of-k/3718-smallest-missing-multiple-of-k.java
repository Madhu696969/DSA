class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs=new HashSet<>();
        for(int ele:nums){
            hs.add(ele);
        }
        int idx=2;
        int val=k;
        while(hs.contains(val)){
            val=k*idx;
            idx++;
        }
        return val;
    }
}