class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        
        //  Sort the array
        // Intialize start and end variables to 0
        //  Iterate through array
        //  If index > 0 && current val at index == val at prev index
        // Set start to end + 1
        // Set end to the last index of our res
        // Iterate through array from start to end
        // Get a new arraylist from the index at start from res
        // Add current num to new arraylist
        // add new arraylist to res
        // Return the result
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        int start = 0, end = 0;
        for(int i = 0; i < nums.length; ++i){
            start = 0;
            if(i > 0 && nums[i] == nums[i-1])
                start = end + 1;
            end = res.size()-1;
            for(int j = start; j <= end; ++j){
                List<Integer> curr = new ArrayList<>(res.get(j));
                curr.add(nums[i]);
                res.add(curr);
            }
        }
        return res;
    }
}