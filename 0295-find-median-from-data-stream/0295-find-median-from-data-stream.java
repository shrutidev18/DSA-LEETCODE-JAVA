class MedianFinder {
    PriorityQueue<Integer> left =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> right =
        new PriorityQueue<>();

    public MedianFinder() {

    }
    
    public void addNum(int num) {
        if(left.isEmpty() || num<=left.peek()){
            left.offer(num);
        }
        else{
            right.offer(num);
        }
        if(left.size() > right.size()+1){
            right.offer(left.poll());
        }
        if (right.size() > left.size() + 1) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if((left.size()+right.size())%2 ==0){
            return (left.peek()+right.peek())/2.0;
        } 
        if (left.size() > right.size()) {
            return left.peek();
        }
        return right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */