class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, 1);
        }
        
        backtrack(res, nums, new ArrayList<>(), map);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> curr, HashMap<Integer, Integer> map){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0; i < nums.length; ++i){
            if(map.get(nums[i]) == 0)
                continue;
            curr.add(nums[i]);
            
            map.put(nums[i], map.get(nums[i]) -1);
            backtrack(res, nums, curr, map);
            map.put(nums[i], map.get(nums[i]) + 1);
            curr.remove(curr.size()-1);
        }
    }
}