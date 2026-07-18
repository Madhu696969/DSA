class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            return Double.compare(b.fract,a.fract);
        });
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                double fract = (double) arr[i] / arr[j];
                if(pq.size()<k){
                    pq.offer(new Pair(i,j,fract));
                }
                else if(pq.peek().fract>fract){
                    pq.poll();
                    pq.offer(new Pair(i,j,fract));
                }
            }
        }
        Pair p1=pq.poll();
        return new int[]{arr[p1.idx1],arr[p1.idx2]};
    }
}
class Pair{
    int idx1;
    int idx2;
    double fract;
    Pair(int idx1,int idx2,double fract){
        this.idx1=idx1;
        this.idx2=idx2;
        this.fract=fract;
    }
}