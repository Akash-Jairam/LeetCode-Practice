class Solution {
    public void nextPermutation(int[] nums) {
        // Find the last peak by iterating from right to left through the array and returning the first number you find where the number to the left of it is lower than it
        // The point to the left of the last peak is the pivot
        // If the pivot is not equal to -1, we will iterate through the array once more from right to left and find the index of first value that is greater than the pivot
        // Swap the values at the pivot and the index of the first value from the right that is greater than the pivot
        // Reverse all the values between the position after the pivot and the end of the array
        int pivot = findLastPeak(nums) -1;
        if(pivot != -1){
            int swapPos = findFirstGreaterThanPivot(nums, pivot);
            swap(nums, pivot, swapPos);
        }
        reverse(nums, pivot+1);
    }
    
    public int findLastPeak(int[] nums){
        for(int i = nums.length-1; i > 0; --i){
            if(nums[i] > nums[i-1])
                return i;
        }
        return 0;
    }
    
    public int findFirstGreaterThanPivot(int[] nums, int pivot){
        for(int i = nums.length-1; i > pivot; --i){
            if(nums[i] > nums[pivot])
                return i;
        }
        return pivot+1;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}