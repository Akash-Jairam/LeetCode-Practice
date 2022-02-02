class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int currentLeftProduct = 1;
        int currentRightProduct = 1;
        for(int i = 0; i < nums.length; ++i){
            currentLeftProduct *= nums[i];
            leftProduct[i] = currentLeftProduct;
        }
        for(int i = nums.length-1; i >=0; --i){
            currentRightProduct *= nums[i];
            rightProduct[i] = currentRightProduct;
        }
        
        for(int i = 0; i < nums.length; ++i){
            if(i -1 >= 0 && i + 1 < nums.length){
                int right = rightProduct[i+1];
                int left = leftProduct[i-1];
                nums[i] =  left * right; ;
            }
            else if(i - 1 < 0 && i + 1 < nums.length)
                nums[i] = rightProduct[i+1];
            else{
                nums[i] = leftProduct[i-1];
            }
        }
        return nums;
    }
}