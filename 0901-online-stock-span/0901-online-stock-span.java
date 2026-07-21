class StockSpanner {
    Stack<Pair> st;
    public StockSpanner() {
        this.st=new Stack<>();
    }
    public int next(int price) {
        int idx=1;
        while(!st.isEmpty() && st.peek().price <=price){
            idx+=st.pop().idx;
        }
        st.push(new Pair(price,idx));
        return idx;   
    }
}

class Pair{
    int price;
    int idx;
    Pair(int price,int idx){
        this.price=price;
        this.idx=idx;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */