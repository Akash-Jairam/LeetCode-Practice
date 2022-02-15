class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsets(subsets, nums, 0, new ArrayList<>());
        return subsets;
    }
    
    public void findSubsets(List<List<Integer>> subsets, int[] nums, int start, List<Integer> current){
        subsets.add(new ArrayList<>(current));
        
        for(int index = start; index < nums.length; ++index ){
            current.add(nums[index]);
            findSubsets(subsets, nums, index + 1, current);
            current.remove(current.size()-1);
        }
    }
}