class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k < 0)
            return new int[0];
        
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        LinkedList<Integer> dq = new LinkedList<>();
        
        for(int i = 0; i < nums.length; ++i){
            if(!dq.isEmpty() && dq.peek() <  i - k + 1)
                dq.poll();
            
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if(i - k + 1 >= 0){
                res[i - k + 1] = nums[dq.peek()];
            }
        }
        
        return res;
    }
}