class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        int max = dp[1];
        
        for(int i = 1; i < nums.length; ++i){
            int currMax = 0;
            for(int j = i-1; j >= 0; --j){
                currMax = Math.max(currMax, dp[j]);
            }
            dp[i+1] = nums[i] + currMax;
            max = Math.max(max, dp[i+1]);
        }
        
        return max;
    }
}