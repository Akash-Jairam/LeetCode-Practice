class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int runningTotal = 0;
        int maxTotal = 0;
        int zeroCount = 0;
        boolean hasZero = false;
        int lastZero = 0;
        
        int left = 0;
        int right = 0;
        
        while(right < nums.length){
            if(nums[right] == 0){
                zeroCount++;
            }
        
        
        while(zeroCount == 2){
            if(nums[left] == 0){
                zeroCount--;
            }
            left++;
        }
            
            maxTotal = Math.max(maxTotal, right - left +1);
            right++;
        }
    
        return maxTotal;
    }
}