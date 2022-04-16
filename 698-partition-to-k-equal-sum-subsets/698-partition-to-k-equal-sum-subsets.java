class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum % k != 0)
            return false;
        
        if(nums.length < k)
            return false;
        return canPartition(nums, new boolean[nums.length], 0, k, 0, sum / k);
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