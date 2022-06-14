class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        
        if(nums == null || nums.length == 0)
            return result;
        
        result[0] = findStartPosition(nums, target);
        result[1] = findEndPosition(nums, target);
        
        return result;
    }
    
    public int findStartPosition(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                idx = mid;
                end = mid - 1;
            } else if(nums[mid] < target){
                start = mid + 1;
            } else 
                end = mid - 1;
        }
        
        return idx;
    }
    
    public int findEndPosition(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                start = mid + 1;
                idx = mid;
            } else if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return idx;
    }
}