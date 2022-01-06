class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        
        int first = 0;
        int last = nums.length-1;
        int mid;
        int secondToLastMid = 0;
        
        while(first < last){
            mid = (first + (last - first)/2);
            if(nums[mid] < target)
                first = mid+1;
            else if(nums[mid] > target) {
                secondToLastMid = last;
                last = mid-1;
            } else{
                return mid;
            }
        }
        
        if(nums[first] != target){
            if(nums[first] < target)
                return first+1;
        }
        return first;
    }
}