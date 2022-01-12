class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0], minSoFar = nums[0];
        int result = maxSoFar;
        
        
        for(int j = 1; j < nums.length; j++){
            int current = nums[j];
            int temp_max = Math.max(current, Math.max(maxSoFar * current, minSoFar * current));
            minSoFar = Math.min(current, Math.min(maxSoFar * current, minSoFar * current));
            maxSoFar = temp_max;
            
            result = Math.max(maxSoFar, result);
        }
        
         
        
        return result;
    }
}