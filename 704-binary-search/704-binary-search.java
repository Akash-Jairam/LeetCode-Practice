class Solution {
    public int search(int[] nums, int target) {
        int beginning = 0;
        int end = nums.length-1;
        int mid = (end + (end - beginning)) / 2;
        
        while(beginning <= end){
            if(nums[mid] < target){
                beginning = mid+1;
                mid = (end + (end - beginning)) /2;
            } else if (nums[mid] > target){
                end = mid-1;
                mid = (end + (end - beginning))/2;
            } else
                return mid;
        }
        
        return -1;
    }
}