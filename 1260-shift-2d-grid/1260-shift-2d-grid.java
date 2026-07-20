class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[] cur=new int[n*m];
        int idx=0;
        for(int[] a:grid){
            for(int ele:a)
            cur[idx++]=ele;
        }
        k%=(n*m);
        k=(n*m-k)%(n*m);
        reverse(cur,0,k-1);
        reverse(cur,k,cur.length-1);
        reverse(cur,0,cur.length-1);
        ArrayList<List<Integer>> res=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<cur.length;i++){
            ls.add(cur[i]);
            if((i+1)%m==0){
                res.add(ls);
                ls=new ArrayList<>();
            }
        }
        return res;
    }
    private void reverse(int[] cur,int st,int end){
        while(st<=end){
            int t=cur[st];
            cur[st]=cur[end];
            cur[end]=t;
            st++;
            end--;
        }
    }
}