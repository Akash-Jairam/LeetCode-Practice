class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>((num1, num2) -> num1 - num2);
        for(int num : nums){
            pq.offer(num);
        }
        level(pq);
    }
    
    public int add(int val) {
        pq.offer(val);
        return level(pq);
    }
    
    public int level(PriorityQueue<Integer> pq){
        if(pq.size() < k)
            return -1;
        while(pq.size() != k)
            pq.poll();
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */