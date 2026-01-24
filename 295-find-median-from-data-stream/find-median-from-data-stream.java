class MedianFinder {
     PriorityQueue<Integer>  Max_heap;
      
     PriorityQueue<Integer> Min_heap;

    public MedianFinder() {
        Max_heap=new PriorityQueue<>(Collections.reverseOrder());
        Min_heap=new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        
        Max_heap.offer(num);
        Min_heap.offer(Max_heap.poll());
        if(Min_heap.size()>Max_heap.size()){
            Max_heap.offer(Min_heap.poll());
        }


       
    }
    public double findMedian() {
        if(Max_heap.size()==Min_heap.size()){
            double val=Max_heap.peek()+Min_heap.peek();
            return (double)(val/2);
        }
        
        return (double) Max_heap.peek();
        }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */