class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        leftProduct[0] = nums[0];
        rightProduct[nums.length-1] = nums[nums.length-1];
        
        for(int i = 1; i < nums.length; ++i){
            leftProduct[i] = leftProduct[i-1] * nums[i];
        }
        
        for(int i = nums.length-2; i >= 0; --i){
            rightProduct[i] = rightProduct[i+1] * nums[i];
        }
        
        if(nums.length > 1){
            nums[0] = rightProduct[1];
            nums[nums.length-1] = leftProduct[nums.length-2];
        }
        
        for(int i = 1; i < nums.length-1; ++i){
            nums[i] = leftProduct[i-1] * rightProduct[i+1];
        }
        
        return nums;
    }
}