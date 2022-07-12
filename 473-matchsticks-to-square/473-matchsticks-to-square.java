class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        
        for(int match : matchsticks){
            sum += match;
        }
        
        if(sum % 4 != 0 || matchsticks.length < 4)
            return false;
        
        return canPartition(matchsticks ,new boolean[matchsticks.length], 0, 4, 0, sum / 4);
    }
    
    public boolean canPartition(int[] nums, boolean[] used, int start, int k, int curSum, int targetSum){
        if(k == 1)
            return true;
        
        if(curSum > targetSum)
            return false;
        
        if(curSum == targetSum)
            return canPartition(nums, used, 0, k-1, 0, targetSum);
        
        for(int i = start; i < nums.length; ++i){
            if(used[i]) continue;
            used[i] = true;
            if(canPartition(nums, used, i+1, k, curSum + nums[i], targetSum))
                return true;
            used[i] = false;
        }
        
        return false;
    }
}