// 1074. Number of Submatrices That Sum to Target

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int res=0;
        for(int i=0;i<m;i++){
            int[] dp=new int[n];
            for(int j=i;j<m;j++){
                for(int l=0;l<n;l++){
                    dp[l]+=matrix[l][j];
                }
                res+=helper(dp,target);
            }
        }
        return res;
    }
    private int helper(int[] dp,int target){
        HashMap<Integer,Integer> mp=new HashMap<>();
        int res=0,s=0;
        mp.put(0,1);
        for(int i=0;i<dp.length;i++){
            s+=dp[i];
            if(mp.containsKey(s-target)){
                res+=mp.get(s-target);
            }
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        return res;
    }
}