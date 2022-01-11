class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int currentSum = -1;
        int i = 0;
        int j;
        
        Arrays.sort(nums);
        if(nums[nums.length/2] > k){
            j = (nums.length/2) -1;
        }else
            j = nums.length-1;
        
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum >= k)
                j--;
            else if(sum  > currentSum){
                currentSum = sum;
            } else if (sum <= currentSum){
                i++;
            }
        }
        
        return currentSum;
    }
}