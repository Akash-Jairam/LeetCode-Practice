class Solution {
    public int missingNumber(int[] nums) {
        // Create a variable to store the sum of the elements in nums
        // Create a variable to store the sum of elements from 0 to n
        int sum = 0;
        int elementSum = 0;
        
        for(int i = 0; i < nums.length; ++i){
            sum += i+1;
            elementSum += nums[i];
        }
        
        return Math.abs(sum - elementSum);
    }
}