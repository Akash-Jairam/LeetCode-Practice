class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       // Sort the array
       // Create list of lists'
       // Iterate through array
       // Make sum 0 - current element
       // create a left pointer and point it to the value after the current element
       // Create a right pointer and point it to the last element
       // Use these two pointers to loop through rest of array
       // If left value + right vale = sum, add current element, current left and current right to list of lists;
       // Increment left pointer until the value it points to is no longer equal to our left value
       // Decrement right pointer until the value it points to is no longer equal to our right value
       // Return list;
       Arrays.sort(nums);
       List<List<Integer>> result = new LinkedList();
       for(int i = 0; i < nums.length-2; ++i){
           if(i == 0 || nums[i] != nums[i-1]){
           int sum = 0 - nums[i];
           int left = i+1;
           int right = nums.length-1;
           while(left < right){
               if(nums[left] + nums[right] == sum){
                   result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                   while(left < right && nums[left] == nums[left+1]) left++;
                   while(left < right && nums[right] == nums[right-1]) right--;
                   left++;
                   right--;
               } else if(nums[left] + nums[right] > sum)
                   right--;
               else
                   left++;
           }
       }}
       return result;
    }
}