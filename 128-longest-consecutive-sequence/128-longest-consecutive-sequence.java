class Solution {
    public int longestConsecutive(int[] nums) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
       if(nums == null || nums.length == 0)
        return 0;
        
       for(int num : nums){
           pq.offer(num);
       }
        
       int count = 1;
       int max = 1;
       int prev = pq.isEmpty() ? -1 : pq.peek();
        
       while(!pq.isEmpty()){
           int curr = pq.poll();
           if(curr == prev -1)
               ++count;
           else if(curr == prev)
               continue;
           else{
               max = Math.max(max, count);
               count = 1;
           }
           prev = curr;
       }
        
       return Math.max(max, count);
    }
}