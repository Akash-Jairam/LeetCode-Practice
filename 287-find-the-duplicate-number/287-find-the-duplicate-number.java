class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        int start = 0, end = nums.length - 1;
        
        while(start < end){
            if(nums[start] == nums[start + 1] )
                return nums[start];
            
            if(nums[end] == nums[end - 1])
                return nums[end];
            ++start;
            --end;
        }
        
        return nums[start];
    }
}