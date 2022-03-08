class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 2)
            return res;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; ++i){
            if(i == 0 || nums[i] != nums[i-1]){
            List<Integer> current = new ArrayList<>();
            int sum = nums[i];
            int start = i+1;
            int end = nums.length-1;
            while(start < end){
                if(nums[start] + nums[end] + sum == 0){
                    current.add(sum);
                    current.add(nums[start]);
                    current.add(nums[end]);
                    res.add(current);
                    current = new ArrayList<>();
                    while(start < end && nums[start] == nums[start+1]) ++start;
                    while(end > start && nums[end] == nums[end-1]) --end;
                    ++start;
                    --end;
                }
                else if(nums[start] + nums[end] < Math.abs(sum))
                    ++start;
                else if(nums[start] + nums[end] > Math.abs(sum))
                    --end;
            }
        }
        
    }
    return res;

}}
