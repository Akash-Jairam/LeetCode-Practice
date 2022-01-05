class Solution {
    public int maxSubArray(int[] nums) {
         if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0];



       int max=Integer.MIN_VALUE;
        int sum=0;
        
        for(int num:nums) {
            sum+=num;
            if(sum<num) {
                sum=num;
            }
            max=Math.max(max, sum);
        }
        
        return max;
    }
}