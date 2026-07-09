class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp=new int[n];

        for(int i=1;i<n;i++){
            int dif=Math.abs(nums[i]-nums[i-1]);
            if(dif<=maxDiff){
                comp[i]=comp[i-1];
            }
            else{
                comp[i]=i;
            }
        }
        boolean[] res=new boolean[queries.length];
        
        for(int i=0;i<queries.length;i++){
            int n1=queries[i][0],n2=queries[i][1];
            if(comp[n1]==comp[n2]){
                res[i]=true;
            }
        }
        return res;
    }
}