class Solution {
    public void nextPermutation(int[] nums) {
        // Find the last index in the array from where all the following elements are lower than it (the last peak)
        // Mark the element that is left of the last peak as the pivot
        // From the pivot, look for the smallest number that is greater than the pivot
        // Sort everything after the pivot in non descending order
        int pivot = findLastPeak(nums) -1;
        if(pivot != -1){
            int toSwap = findValToSwap(nums, pivot);
            swap(nums, pivot, toSwap);
        } 
            reverse(nums, pivot+1);
        
    }
    
    public int findLastPeak(int[] nums){
        for(int i = nums.length-1; i>0; --i){
            if(nums[i] > nums[i-1]){
                return i;
            }
        }
        return 0;
    }
    
    public int findValToSwap(int[] nums, int pivot){
        int max = nums[pivot+1];
        for(int i = nums.length-1; i > pivot; --i){
            if(nums[i] > nums[pivot] )
                return i;
        }
        return nums.length-1;
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