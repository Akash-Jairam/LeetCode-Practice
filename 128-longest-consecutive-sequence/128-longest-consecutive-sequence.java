class Solution {
    public int longestConsecutive(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        if(nums.length == 0)
            return 0;
        int longest = 1;
        
        for(int num : nums){
            set.add(num);
        }
        
        for(int i = 0; i < nums.length; ++i){
            if(!set.contains(nums[i] -1)){
                int count = 1;
                int curr = nums[i] + 1;
                while(set.contains(curr)){
                    ++curr;
                    ++count;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}