class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
        if(nums.length == 0)
            return subsets;
                 Arrays.sort(nums);

    subsets.add(new ArrayList<>());
    int startIndex = 0, endIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      startIndex = 0;
      // if current and the previous elements are same, create new subsets only from the subsets 
      // added in the previous step
      if (i > 0 && nums[i] == nums[i - 1])
        startIndex = endIndex + 1;
      endIndex = subsets.size() - 1;
      for (int j = startIndex; j <= endIndex; j++) {
        // create a new subset from the existing subset and add the current element to it
        List<Integer> set = new ArrayList<>(subsets.get(j));
        set.add(nums[i]);
        subsets.add(set);
      }
    }
    return subsets;
    }
}