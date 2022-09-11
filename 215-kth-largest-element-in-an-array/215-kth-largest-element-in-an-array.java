class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (x - y));
        
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k) pq.poll();
        }
        
        return pq.peek();
    }
}