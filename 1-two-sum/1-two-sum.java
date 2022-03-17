class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap where the key and value with both be of integer type
        // The key will represent the number at an index while the value will be the corresponding index
        // Iterate through the array and check to see if the difference between the target and the current number is in the array
        // If it is, return the current index and the index of the stored number
        // Else, put the current number and the current index into the map
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums.length == 0)
            return new int[]{};
        
        for(int i = 0; i < nums.length; ++i){
            if(map.containsKey(target - nums[i])){
                return new int[] {i, map.get(target - nums[i])};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }
}