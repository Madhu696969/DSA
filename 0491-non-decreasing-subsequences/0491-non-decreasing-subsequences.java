class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        solve(nums,0,ls,res);
        return res;
    }
    private void solve(int[] nums,int idx,List<Integer> ls,List<List<Integer>> res){
        if(ls.size()>=2){
            res.add(new ArrayList<>(ls));
        }
        if(idx==nums.length){
            return;
        }
        HashSet<Integer> hs=new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(hs.contains(nums[i])){
                continue;
            }
            if(ls.isEmpty() || ls.get(ls.size()-1)<=nums[i]){
                hs.add(nums[i]);
                ls.add(nums[i]);
                solve(nums,i+1,ls,res);
                ls.remove(ls.size()-1);
            }
        }
    }
}