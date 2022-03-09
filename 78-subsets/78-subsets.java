class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        res.add(new ArrayList<>());
        // Iterate through our nums array
        // Get the current size of res
        // For loop according to current size
        // Get a new array list based on the current size
        // Add current num to new array list
        // Add new array list to res
        // Return res
        
        for(int num : nums){
            int size = res.size();
            for(int i = 0; i < size; ++i){
                List<Integer> curr = new ArrayList<>(res.get(i));
                curr.add(num);
                res.add(curr);
            }
        }
        
        return res;
    }
}