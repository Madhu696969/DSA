class MedianFinder {

    private PriorityQueue<Integer> max_heap=new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> min_heap=new PriorityQueue<>();
    private boolean isEven=true;
    public MedianFinder() {
    }
    public void addNum(int num) {
        if(isEven){
            min_heap.offer(num);
            max_heap.offer(min_heap.poll());
        }   
        else{
            max_heap.offer(num);
            min_heap.offer(max_heap.poll());
        }

        isEven=!isEven;
    }
    public double findMedian() {
        if(isEven){
            return (max_heap.peek()+min_heap.peek())/2.0;
        }
        return max_heap.peek();   
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */