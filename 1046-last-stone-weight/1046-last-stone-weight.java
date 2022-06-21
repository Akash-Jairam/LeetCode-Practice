class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (y - x));
        
        for(int stone : stones){
            pq.offer(stone);
        }
        
        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();
            
            if(y - x > 0)
                pq.offer(y - x);
        }
        
        return pq.isEmpty() ? 0 : pq.peek();
    }
}