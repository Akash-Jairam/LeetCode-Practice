class Solution {
    public int search(int[] nums, int target) {
        // Find the pivot
        // Determine where the target stands based on the pivot
        // Do regular binary search
        if(nums == null || nums.length == 0)
            return -1;
        
        int pivot = findPivot(nums);
        int start = 0;
        int end = nums.length-1;
        if(target >= nums[pivot] && target <= nums[end])
            start = pivot;
        else
            end = pivot -1;
        
        return binarySearch(nums, start, end, target);
    }
    
    public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[end])
                start = mid+1;
            else
                end = mid;
        }
        
        return start;
    }
    
    public int binarySearch(int[] nums, int start, int end, int target){
        while(start < end){
            int mid = start + (end - start) / 2;
            if(target > nums[mid]){
                start = mid + 1;
            } else
                end = mid;
        }
        
        return nums[start] == target ? start : -1;
    }
}