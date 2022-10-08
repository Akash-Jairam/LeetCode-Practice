class Solution {
    public int threeSumClosest(int[] nums, int target) {
      /*
      * Initialize our result with the sum of the first value, second value and last value
      * Sort the array
      * Loop through array starting at the first index
      * Create a pointer that is set to the value after the first iterator
      * Create a pointer that is set to the last value in the array
      * Calculate the sum using the iterator and the two pointers
      * If the sum > target, decrement the right pointer
      * Else increment the left pointer
      * Compare the absolute difference between the target and the sum and the target and the result
      * If the absolute difference for the former is less than the latter, update the result
      * Return our result 
      */
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ++i){
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > target){
                    right--;
                } else{
                    left++;
                }
                if(Math.abs(target - sum) < Math.abs(target - result))
                    result = sum;
            }
        }
        
        return result;
          
    }
}