class Solution {
    public int arraySign(int[] nums) {
        int numNegative = 0;
        
        for(int num : nums){
            if(num == 0)
                return 0;
            if(num < 0)
                ++numNegative;
        }
        
        return numNegative % 2 == 0 ? 1 : -1;
    }
}