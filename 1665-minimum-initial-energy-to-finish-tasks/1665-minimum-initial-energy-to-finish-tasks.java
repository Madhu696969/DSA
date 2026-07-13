class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->
            (b[1]-b[0])-(a[1]-a[0]));
        long res=0;
        long en=0;
        for(int i=0;i<tasks.length;i++){
            int act=tasks[i][0];
            int min=tasks[i][1];
            if(en<min){
                res+=(min-en);
                en=min;
            }
            en-=act;
        }
        return (int)res;

    }
}