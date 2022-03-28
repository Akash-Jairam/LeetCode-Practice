class Solution {
    public int findMin(int[] nums) {
        return binarySearch(0, nums.length-1, nums);
    }
    
    public int binarySearch(int left, int right, int[] nums){
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right])
                return binarySearch(mid+1, right, nums);
            
            if(nums[mid] < nums[right])
                right = mid;
            else 
                left = mid+1;
        }
        
        return nums[left];
    }
}