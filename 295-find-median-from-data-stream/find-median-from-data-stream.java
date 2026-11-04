class MedianFinder {
    PriorityQueue<Integer> min_h;
     PriorityQueue<Integer> max_h;

    public MedianFinder() {
        min_h=new PriorityQueue<>();
        max_h=new PriorityQueue<>(Collections.reverseOrder());

        
    }
    
    public void addNum(int num) {
        
        if(max_h.isEmpty()||max_h.peek()>=num){
            max_h.offer(num);
        }
        else{
            min_h.offer(num);
        }

        if(max_h.size()<min_h.size()){
            max_h.offer(min_h.poll());

        }
        if(max_h.size()>min_h.size()+1){
            min_h.offer(max_h.poll());
        }
        
    }
    
    public double findMedian() {
        if(max_h.size()>min_h.size()){
            return max_h.peek();


        }
        return (max_h.peek()+min_h.peek())/2.0;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */