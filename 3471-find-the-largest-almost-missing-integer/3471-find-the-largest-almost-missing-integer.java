class Solution {
    public int largestInteger(int[] nums, int k) {
      Map<Integer, Integer> frequencyMap = new HashMap<>();

       
        for (int i = 0; i <= nums.length - k; i++) {
            
            boolean[] seen = new boolean[51]; 

            
            for (int j = i; j < i + k; j++) {
                int num = nums[j];
                if (!seen[num]) {
                    seen[num] = true;
                    frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
                }
            }
        }
        int largestMissing = -1;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                largestMissing = Math.max(largestMissing, entry.getKey());
            }
        }

        return largestMissing;  
    }
}