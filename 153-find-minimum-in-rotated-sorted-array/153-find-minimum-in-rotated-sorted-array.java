class Solution {
    public int findMin(int[] nums) {
        // Use binary search
        if(nums.length == 0)
            return 0;
        
        int left = 0;
        int right = nums.length-1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right])
                left = mid+1;
            else
                right = mid;
        }
        
        return nums[left];
    }
}