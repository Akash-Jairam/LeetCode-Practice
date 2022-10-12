class Solution {
    public int largestPerimeter(int[] nums) {
        // In a triangle one side must always be less than the sum of the other sides
        Arrays.sort(nums);
        
        for(int i = nums.length - 1; i > 1; --i){
            if(nums[i] < nums[i-1] + nums[i-2])
                return nums[i] + nums[i-1] + nums[i-2];
        }
        
        return 0;
    }
}