class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        
        int res = -1;
        int left = 0;
        int right = nums.length-1;
        return binarySearch(nums, left, right, target);
    }
    
    public int binarySearch(int[] nums, int left, int right, int target){
        int mid = left + (right - left) / 2;
    
        if(nums[mid] == target)
            return mid;
        else if(left >= right)
            return -1;
        else {
            mid = Math.max(binarySearch(nums, left, mid, target), binarySearch(nums, mid+1, right, target));
        }
        
        return mid;
    }
}