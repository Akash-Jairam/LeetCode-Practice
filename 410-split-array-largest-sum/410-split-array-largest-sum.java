class Solution {
    public int splitArray(int[] nums, int m) {
        // The answer will be in the range of two cases
        // The first is m = 1 where each element will be a subarray and the largest sum would be the largest element in the array
        // The other case is where m == nums.length where the subarray will be the entire array and the total sum would be the largest element in the array
        // Once we get these values, we can do a binary search where we find the midpoint between our two ranges and check to see if our array can be split up into m groups where the largest sum is equal to that midpoint
        // If this is true, we bring the lowest point up to the point after the midpoint
        // Else we bring the highest point down to the point before the midpoint
        // We can return either the final lowest or highest point which should be equal
        int min = -1;
        int sum = 0;
        
        for(int num : nums){
            min = Math.max(min, num);
            sum += num;
        }
        
        int low = min;
        int high = sum;
        
        while(low < high){
            int mid = low + (high - low) / 2;
            if(canSplit(nums, mid, m)){
                high = mid;
            } else{
                low = mid+1;
            }
        }
        
        return low;
    }
    
    public boolean canSplit(int[] nums, int largestSumCandidate, int m){
        int sum = 0;
        int numSubArrays = 1;
        
        for(int num : nums){
            sum += num;
            if(sum > largestSumCandidate){
                numSubArrays++;
                if(numSubArrays > m)
                    return false;
                sum = num;
            }
        }
        
        return true;
    }
}