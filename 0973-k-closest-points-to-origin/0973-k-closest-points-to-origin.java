class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            return Long.compare(b.dis,a.dis);
        });
        for(int[] point:points){
            int x=point[0];
            int y=point[1];
            long dis = 1L*x*x+1L*y*y;
            if(pq.size()<k){
                pq.offer(new Pair(dis,x,y));
            }
            else{
                if(pq.peek().dis > dis){
                    pq.poll();
                    pq.offer(new Pair(dis,x,y));
                }
            }
        }
        int[][] res=new int[k][2];
        int idx=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            res[idx][0]=p.x;
            res[idx][1]=p.y;
            idx++;
        } 
        return res;
    }
}
class Pair{
    long dis;
    int x;
    int y;
    Pair(long dis,int x,int y){
        this.dis=dis;
        this.x=x;
        this.y=y;
    }
}