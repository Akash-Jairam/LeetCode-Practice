class Solution {
    public int splitArray(int[] nums, int m) {
        // Thing of the two edge cases
        // On one hand, m could be 1 and the largest sum amongst the subarrays would be the highest number in nums
        // On the other hand, m could be nums.length and the largest sum amongst the subarray would be the total sum of its elements since you will be creating just one array
        // We need to iterate through our array and find these values
        // We need to perform a binary using these values to see if we can split our array into m parts until we get the minimum largest sum
        
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
    
    public boolean canSplit(int[] nums, int minLargestCandidate, int m){
        int sum = 0;
        int arrayCount = 1;
        for(int num : nums){
            sum += num;
            if(sum > minLargestCandidate){
                ++arrayCount;
                sum = num;
                if(arrayCount > m)
                    return false;
                
            }
            
        }
        
        return true;
    }
}