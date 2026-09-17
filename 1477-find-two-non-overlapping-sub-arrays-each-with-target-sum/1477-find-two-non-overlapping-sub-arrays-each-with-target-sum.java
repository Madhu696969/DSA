class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] preMin=new int[n];
        Arrays.fill(preMin,Integer.MAX_VALUE);
        int i=0,j=0,res=Integer.MAX_VALUE,prevMin=Integer.MAX_VALUE,curS=0;
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
                prevMin=Math.min(len,prevMin);
            }
            preMin[j]=prevMin;
            j++;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}