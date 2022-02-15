class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        fill(subset, nums, 0, new ArrayList<Integer>());
        return subset;
    }
    
    public void fill(List<List<Integer>> result, int[] nums, int start, List<Integer> current){
        result.add(new ArrayList<>(current));
        for(int index = start; index < nums.length; ++index){
            current.add(nums[index]);
            fill(result, nums, index+1, current);
            current.remove(current.size()-1);
        }
    }
}