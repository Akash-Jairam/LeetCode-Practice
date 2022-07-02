class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (x - y));
        
        for(int num : nums){
            pq.offer((a * num * num) + (b * num) + c);
        }
        
        for(int i = 0; i < nums.length; ++i){
            nums[i] = pq.poll();
        }
        
        return nums;
    }
}