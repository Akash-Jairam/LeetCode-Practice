class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0)
            return nums;
        
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // Create linked list to hold the indices of the k elements in nums in desc order
        LinkedList<Integer> dq = new LinkedList<>();
        // Iterate through nums
        
        for(int i = 0; i < n; ++i){
        // If the dq is not empty and top element is an index which is outside the range of i - k + 1 , remove it
            if(!dq.isEmpty() && dq.peekFirst() < i - k + 1)
                dq.pollFirst();
            
        // While the dq is not empty and the number is the last index is less than the number at the current index, we remove that index from the queue
            while(!dq.isEmpty() && nums[dq.peekLast()] <  nums[i]){
                dq.pollLast();
            }
            
            dq.offerLast(i);
        // If i - k + 1 > 0, we add the first element in our dq to our result array
            if(i - k + 1 >= 0)
                res[i - k + 1] = nums[dq.peekFirst()];
        }
        // Return the result array
        return res;
    }
}