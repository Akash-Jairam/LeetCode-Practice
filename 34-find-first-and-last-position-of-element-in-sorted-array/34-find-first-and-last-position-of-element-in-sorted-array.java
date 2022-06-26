class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length == 0)
            return res;
        
        res[0] = findFirstIndex(nums, target);
        res[1] = findSecondIndex(nums, target);
        return res;
    }
    
    public int findFirstIndex(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid;
            }
            
        }
        
        return nums[start] == target ? start : -1 ;
    }
    
    public int findSecondIndex(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
            int mid = (start + (end - start) / 2) + 1;
            if(nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        
        return nums[end] == target ? end : -1;
    }
}