class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array
        // Make our list to return 
        // Iterate through the array starting at the first index
        // Subtract the current element from 0
        // Make a pointer to the i +1 as left and a right pointer at the last element of the array
        // See if the current numbers + the current element are equal
        // If they are , add to list
        // Else, increment left if it was less or decrement right if it was greater
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; ++i){
            if(i == 0 || nums[i] != nums[i-1]){
            int val = 0 - nums[i];
            int left = i+1;
            int right = nums.length-1;
            List<Integer> list = new ArrayList<>();
            while(left < right){
                    int sum = nums[left] + nums[right];
                    if(sum == val){
                        list.add(nums[left]);
                        list.add(nums[right]);
                        list.add(nums[i]);
                        result.add(list);
                        list = new ArrayList<>();
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(right > left && nums[right] == nums[right-1]) right--;
                        right--;
                        left++;
                    } else if(sum < val)
                        left++;
                    else
                        right--;
                }
            }
            
        }
        return result;
    }
}