class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        dp[0] = nums[0];
        
        for(int i = 1; i < n; ++i){
            if(queue.peekFirst() < i - k)
                queue.pollFirst();
            
            dp[i] = nums[i] + dp[queue.peekFirst()];
            
            while(!queue.isEmpty() && dp[queue.peekLast()] <= dp[i])
                queue.pollLast();
            
            queue.offer(i);
        }
        
        return dp[n-1];
    }
}