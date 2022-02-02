class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Track the progression of the product from the left and the right
        // Find the current product as we move left and put it in an array
        // Find the current product as we move right and put it in an array
        // Iterate through nums and assign the value of the product at the immediate left of nums times the product at the immediate right of nums
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int currentProduct = 1;
        
        for(int i = 0; i < nums.length; ++i){
            currentProduct *= nums[i];
            leftProduct[i] = currentProduct;
        }
        
        currentProduct = 1;
        for(int i = nums.length-1; i>=0; --i){
            currentProduct *= nums[i];
            rightProduct[i] = currentProduct;
        }
        
        for(int i = 0; i < nums.length; ++i){
            if(i-1 >=0 && i+1 < nums.length)
                nums[i] = leftProduct[i-1] * rightProduct[i+1];
            else if(i-1 < 0 && i+1 < nums.length){
                nums[i] = rightProduct[i+1];
            }else
                nums[i] = leftProduct[i-1];
        }
        return nums;
    }
}