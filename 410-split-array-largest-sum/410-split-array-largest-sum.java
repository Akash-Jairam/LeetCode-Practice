class Solution {
    public int splitArray(int[] nums, int m) {
        // Given that m can be the a single element in one edge and the entire length of the array in the other, we can get these values and perform a binary search
        // We do this by cont
        int low = -1;
        int high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }
        
        int largestSum = 0;
        
        while(low < high){
            int midPoint = low + (high-low) /2;
            boolean canReach = check(nums, m, midPoint);
            if(canReach)
                high = midPoint;
            else
                low = midPoint+1;
            
            
        }
        
        return low;
    }
    
    public boolean check(int[] nums, int m, int midpoint){
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