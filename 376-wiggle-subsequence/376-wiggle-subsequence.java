class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2)
            return 1;
        
        Boolean wasPositive = null;
        int count = 1, max = 1;
        
        for(int i = 1; i < nums.length; ++i){
            int diff = nums[i] - nums[i-1];
            if(wasPositive != null){
                if(wasPositive && diff < 0){
                    ++count;
                    wasPositive = false;
                } else if(!wasPositive && diff > 0){
                    ++count;
                    wasPositive = true;
                }
            } else{
               if(diff > 0){
                   wasPositive = true;
                   ++count;
               } else if(diff < 0){
                   wasPositive = false;
                   ++count;
               }
            }
        }
        
        return Math.max(max, count);
    }
}