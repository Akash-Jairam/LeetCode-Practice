class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int robFirst = robHelper(nums,  0, nums.length-1);
        
        int robSecond = robHelper(nums,  1, nums.length);
        
        return Math.max(robFirst, robSecond);
    }
    
    public int robHelper(int[] nums, int start, int end){
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[start];
        int dpIndex = 2;
        
        for(int i = start+1; i < end; ++i){
            dp[dpIndex] = Math.max(dp[dpIndex-1], nums[i] + dp[dpIndex-2]);
            dpIndex++;
        }
        return dp[dpIndex-1];
    }
}