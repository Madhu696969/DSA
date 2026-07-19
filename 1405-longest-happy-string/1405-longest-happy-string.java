class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a1,b1)->{
            return Integer.compare(b1.freq,a1.freq);
        });

        StringBuilder res=new StringBuilder();

        if(a>0)pq.offer(new Pair(a,'a'));
        if(b>0)pq.offer(new Pair(b,'b'));
        if(c>0)pq.offer(new Pair(c,'c'));

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            char ch=p.ch;
            int freq=p.freq;
            if(res.length()>=2 && res.charAt(res.length()-1)==ch && res.charAt(res.length()-2)==ch){
                if(pq.isEmpty()) break;
                Pair p1=pq.poll();
                char ch1=p1.ch;
                int freq1=p1.freq;
                res.append(ch1);
                freq1--;
                if(freq1>0){
                    pq.offer(new Pair(freq1,ch1));
                }
            }
            else{
                res.append(ch);
                freq--;
            }
            if(freq>0)
                pq.offer(new Pair(freq,ch));
        }
        return res.toString();
    }
}

class Pair{
    int freq;
    char ch;
    Pair(int freq,char ch){
        this.freq=freq;
        this.ch=ch;
    }
}