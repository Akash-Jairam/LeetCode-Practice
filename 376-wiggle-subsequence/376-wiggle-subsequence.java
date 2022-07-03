class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 2)
            return 1;
        
        int max = 1;
        int count = 1;
        Boolean wasPositive = null;
        for(int i = nums.length -1; i >= 1; --i){
            int diff = nums[i] - nums[i-1];
            if(wasPositive == null){
                if(diff > 0){
                    wasPositive = true;
                     ++count;
                } else if(diff < 0){
                    wasPositive = false;
                     ++count;
                }
               
            } else if(wasPositive && diff < 0){
                ++count;
                wasPositive = false;
            } else if(!wasPositive && diff > 0){
                ++count;
                wasPositive = true;
            } else {
                max = Math.max(max, count);
            }
        }
        
        return Math.max(max, count);
    }
}