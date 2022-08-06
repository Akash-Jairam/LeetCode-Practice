class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return res;
        
        List<Integer> list = new ArrayList<>();
        for(int num : nums)
            list.add(num);
        
        backtrack(0, res, list);
        return res;
    }
    
    public void backtrack(int i, List<List<Integer>> res, List<Integer> nums){
        if(i == nums.size()){
            res.add(new ArrayList<>(nums));
            return;
        }
        
        for(int j = i; j < nums.size(); ++j){
            swap(i, j, nums);
            backtrack(i+1, res, nums);
            swap(i, j, nums);
        }
    }
    
    public void swap(int i , int j, List<Integer> nums){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}