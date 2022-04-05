class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int size;
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>((num1, num2) -> (num1 - num2));
        this.maxHeap = new PriorityQueue<>((num1, num2) -> (num2 - num1));
        this.size = 0;
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        
        if(minHeap.size() + 1 < maxHeap.size())
            minHeap.offer(maxHeap.poll());
        else if(minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
        ++size;
    }
    
    public double findMedian() {
        if(size % 2 != 0)
            return (double)maxHeap.peek();
        
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */