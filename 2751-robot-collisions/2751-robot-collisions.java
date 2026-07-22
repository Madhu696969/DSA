class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<Pair> st=new Stack<>();
        int n=positions.length;
        List<Pair> ls1=new ArrayList<>();
        for(int i=0;i<n;i++){
            ls1.add(new Pair(positions[i],healths[i],directions.charAt(i),i));
        }
        Collections.sort(ls1,(a,b)->{
            return Integer.compare(a.pos,b.pos);
        });
        for(Pair cur:ls1){
            if(cur.dir=='R'){
                st.push(cur);
            }
            else{
                while(!st.isEmpty() && st.peek().dir=='R' && cur.health>0){
                    Pair right=st.peek();
                    if(right.health<cur.health){
                        st.pop();
                        cur.health--;
                    }
                    else if(right.health==cur.health){
                        st.pop();
                        cur.health=0;
                        break;
                    }
                    else{
                        right.health--;
                        cur.health=0;
                        break;
                    }
                }
                if(cur.health > 0){
                    st.push(cur);
                }
            }
        }
        // Same order
        List<Pair> ls=new ArrayList<>(st);
        Collections.sort(ls,(a,b)->{
            return Integer.compare(a.idx,b.idx);
        });
        List<Integer> res=new ArrayList<>();
        for(Pair p:ls){
            res.add(p.health);
        }
        return res;
    }
}
class Pair{
    int pos;
    int health;
    char dir;
    int idx;
    Pair(int pos,int health,char dir,int idx){
        this.pos=pos;
        this.health=health;
        this.dir=dir;
        this.idx=idx;
    }
}