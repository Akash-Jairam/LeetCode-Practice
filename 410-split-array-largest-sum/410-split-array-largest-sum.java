class Solution {
    public int splitArray(int[] nums, int m) {
        // We see that m can be from 1 to nums.length
        // This means that our solution space is also within that frame
        // We can use this as criteria to perform a binary search
        // We will find the midpoint between the high and the low variables 
        // Before checking to see if it is possible to put our array values in m buckets
        // If it is possible, we will bring our high down to the midpoint
        // Else we will bring our low to midpoint + 1
        int min = -1;
        int sum = 0;
        
        for(int num :  nums){
            min = Math.max(min, num);
            sum += num;
        }
        
        int low = min;
        int high = sum;
        
        while(low < high){
            int midpoint = low + (high - low) / 2;
            if(canSplit(nums, midpoint, m)){
                high = midpoint;
            } else
                low = midpoint + 1;
        }
        
        return high;
    }
    
    public boolean canSplit(int[] nums, int midpoint, int m){
        int count = 1;
        int sum = 0;
        
        for(int num : nums){
            sum += num;
            if(sum > midpoint){
                ++count;
                sum = num;
                if(count > m)
                    return false;
            }
        }
        
        return true;
    }
}