// 363. Max Sum of Rectangle No Larger Than K

class Solution {
    public int maxSumSubmatrix(int[][] arr, int k) {
        int rows = arr.length;
        int cols = arr[0].length;
        int maxK = Integer.MIN_VALUE;
        for(int i=0;i<cols;i++){
            int dp[]=new int[rows];
            for(int j=i;j<cols;j++){
                for(int l=0;l<rows;l++){
                    dp[l]+=arr[l][j];
                }
                int currSum=helper(dp, k);
                maxK=Math.max(maxK,currSum);                 
                if(maxK==k)
                    return k;
            }
        }
        return maxK;
    }
    private int helper(int[] dp,int k){
        TreeSet<Integer> ts=new TreeSet<>();
        ts.add(0);
        int res=Integer.MIN_VALUE,s=0;
        for(int i=0;i<dp.length;i++){
            s+=dp[i];
            Integer val=ts.ceiling(s-k);
            if(val!=null){
                res=Math.max(res,s-val);
            }
            ts.add(s);
        }
        return res;
    }
}