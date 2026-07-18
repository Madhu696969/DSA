class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.add(i);
        }
        int[] res=new int[nums.length-k+1];
        int idx=0;
        for(int i=k;i<nums.length;i++){
            res[idx++]=nums[dq.peekFirst()];
            while(!dq.isEmpty() && (i-dq.peekFirst())>=k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.add(i);
        }
        res[idx++]=nums[dq.peekFirst()];
        return res;
    }
}