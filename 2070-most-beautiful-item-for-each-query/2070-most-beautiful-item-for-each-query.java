class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n=items.length;
        int[] res=new int[queries.length];
        Arrays.sort(items,(a,b)->Integer.compare(a[0],b[0]));
        int[] prefMax=new int[n];
        prefMax[0]=items[0][1];
        for(int i=1;i<n;i++){
            prefMax[i]=Math.max(prefMax[i-1],items[i][1]);
        }
        for(int i=0;i<queries.length;i++){
            int result=GetRes(items,prefMax,queries[i]);
            res[i]=result;
        }
        return res;
    }
    private int GetRes(int[][] items,int[] prefMax,int lim){
        int l=0,h=items.length-1;
        int res=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(items[mid][0]<=lim){
                res=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return res==-1?0:prefMax[res];
    }
}