class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        
        if(nums.length == 0)
            return new int[]{0};
        
        for(int num : nums){
            if(num != 0){
                product *= num;
            } else {
                ++zeroCount;
            }
        }
        
        for(int i = 0; i < nums.length; ++i){
            if(zeroCount == 1 && nums[i] == 0 ){
                nums[i] = product;
            } else if(zeroCount > 1){
                nums[i] = 0;
            } else if(zeroCount == 0){
                nums[i] = product / nums[i];
            } else
                nums[i] = 0;
        }
        
        return nums;
    }
}