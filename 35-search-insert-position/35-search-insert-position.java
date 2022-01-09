class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        
        int left = 0;
        int right = nums.length -1;
        int mid = left + (right - left) / 2;
        while(right > left){
            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid -1;
            } else {
                return mid;
            }
            mid = left + (right - left) / 2;
        }
        
        if(target > nums[mid])
            return mid+1;
        return mid;
    }
}