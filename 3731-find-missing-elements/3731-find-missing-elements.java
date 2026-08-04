class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res=new ArrayList<>();
        int st=nums[0];
        int end=nums[nums.length-1];
        int idx=0;
        for(int i=st;i<=end;i++){
            if(idx==nums.length) break;
            while(i<=end && i!=nums[idx]){
                res.add(i);
                i++;
            }
            idx++;
        }
        return res;
    }
}