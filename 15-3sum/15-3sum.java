class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Create of list of lists to hold the results
        // Check to see if nums == null or nums.length < 3 and return the empty list
        // We'll sort the array
        // Iterate through our array starting from index 0 up to the second to last element in nums
        // Do a check where if the index > 0, and the current number is not equal to the number before it
        // Store the value at the current index
        // Create a hashmap to hold the other values in nums
        // Using a nested loop, iterate throguh the array starting from the index after the previous iterator
        // Check to see if the map contains a key that is the absolute of the difference between the number at the current index and our stored number
        // Also check to see if those three numbers add up to zero
        // If they do, create a list and add them to it
        // Add that list to our list of lists
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return res;
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; ++i){
            if(i == 0 || nums[i] != nums[i-1]){
                int start = i + 1;
                int end = nums.length-1;
                int curr = nums[i];
                while(start < end){
                    if(curr + nums[start] + nums[end] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(curr);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        res.add(list);
                        while(start < end && nums[start] == nums[start + 1]) ++start;
                        while(end > start && nums[end] == nums[end - 1]) --end;
                        ++start;
                        --end;
                    } else if(nums[start] + nums[end] > Math.abs(curr)){
                        --end;
                    } else {
                        ++start;
                    }
                }
            }
        }
        
        
        return res;
    }
}