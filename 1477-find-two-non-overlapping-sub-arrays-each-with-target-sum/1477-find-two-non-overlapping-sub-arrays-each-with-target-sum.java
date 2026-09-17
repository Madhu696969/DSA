class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] preMin=new int[n];
        Arrays.fill(preMin,Integer.MAX_VALUE);
        int res=Integer.MAX_VALUE;
        int curS=0;
        int i=0,j=0;
        int pM=Integer.MAX_VALUE;
        while(j<n){
            curS+=arr[j];
            while(curS>target){
                curS-=arr[i++];
            }
            if(curS==target){
                int len=j-i+1;
                if(i>0 && preMin[i-1]!=Integer.MAX_VALUE){
                    res=Math.min(res,len+preMin[i-1]);
                }
                pM=Math.min(len,pM);
            }
            preMin[j]=pM;
            j++;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}