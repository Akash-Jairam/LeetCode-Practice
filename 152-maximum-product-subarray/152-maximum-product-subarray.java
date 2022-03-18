class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; ++i){
            int tempMax = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
            minSoFar = Math.min(nums[i], Math.min(maxSoFar * nums[i], minSoFar * nums[i]));
            
            maxSoFar = tempMax;
            max = Math.max(max, maxSoFar);
            
        }
        
        return max;
    }
}