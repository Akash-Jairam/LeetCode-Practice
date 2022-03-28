class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int lowestProduct = nums[0];
        int highestProduct = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; ++i ){
            int currProdLo = nums[i] * lowestProduct;
            int currProdHi = nums[i] * highestProduct;
            int tempHi = Math.max(nums[i], Math.max(currProdLo, currProdHi));
            lowestProduct = Math.min(nums[i], Math.min(currProdLo, currProdHi));
            highestProduct = tempHi;
            max = Math.max(max, highestProduct);
        }
        
        return max;
    }
}