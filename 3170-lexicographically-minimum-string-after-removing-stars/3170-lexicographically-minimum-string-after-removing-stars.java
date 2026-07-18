class Solution {
    public String clearStars(String s) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.ch==b.ch)
                return b.idx-a.idx;
            return a.ch-b.ch; 
        });
        StringBuilder res1=new StringBuilder(s);
        for(int i=0;i<res1.length();i++){
            if(res1.charAt(i)!='*'){
                pq.offer(new Pair(res1.charAt(i),i));
            }
            else{
                Pair p=pq.poll();
                res1.setCharAt(p.idx,'*');
            }
        }
        String res="";
        for(int i=0;i<res1.length();i++){
            if(res1.charAt(i)!='*'){
                res+=res1.charAt(i);
            }
        }
        return res;
    }
}
class Pair{
    char ch;
    int idx;
    Pair(char ch,int idx){
        this.ch=ch;
        this.idx=idx;
    }
}