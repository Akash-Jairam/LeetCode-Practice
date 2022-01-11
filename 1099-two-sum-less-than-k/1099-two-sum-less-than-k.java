class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int currentSum = Integer.MIN_VALUE;
        int i = 0;
        int sum = 0;
        int j;
        
        Arrays.sort(nums);
        if(nums[nums.length/2] > k){
            j = (nums.length/2) -1;
        }else
            j = nums.length-1;
        
        while(i < j){
            sum = nums[i] + nums[j];
            if(sum >= k)
                j--;
            else if(sum  > currentSum){
                currentSum = sum;
            } else if (sum <= currentSum){
                i++;
            }
        }
        
        if(currentSum == Integer.MIN_VALUE)
            return -1;
        else
            return currentSum;
    }
}