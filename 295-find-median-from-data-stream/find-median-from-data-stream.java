class MedianFinder {
    PriorityQueue<Integer> max_heap;
    PriorityQueue<Integer> min_heap;


    public MedianFinder() {
        max_heap=new PriorityQueue<>(Collections.reverseOrder());
        min_heap=new PriorityQueue<>(); 
        
    }
    
    public void addNum(int num) {
        if(max_heap.isEmpty() || num<=max_heap.peek()){
            max_heap.offer(num);
        }
        else{
        min_heap.offer(num);
        }
        if(max_heap.size()>min_heap.size()+1){
            min_heap.offer(max_heap.poll());
        }
        
        if(min_heap.size()>max_heap.size()){
            max_heap.offer(min_heap.poll());
        }
        

        
        
    }
    
    public double findMedian() {
        if(max_heap.size()==min_heap.size()){
        double ans=(double)max_heap.peek()+(double)min_heap.peek();
        return ans/2;
        }
        else{
            return (double)max_heap.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */