class Solution {
    public int findMin(int[] nums) {
        int end = nums.length - 1;
        int start = 0;
        
        while(nums[start] >= nums[end] && start < nums.length - 1)
            ++start;
        
        return nums[start];
    }
}