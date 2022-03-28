class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int pivot = findPivot(nums);
        int end = nums.length-1;
        int start = 0;
        
            if(target >= nums[pivot] && target <= nums[end])
                start = pivot;
            else {
                end = pivot-1;
            }
        
        
        return binarySearch(start, end, nums, target);
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
    
    public int binarySearch(int start, int end, int[] nums, int target){
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid  + 1;
            } else{
                end = mid;
            }
        }
        
        return nums[start] == target ? start : -1;
    }
}