class Solution {
    public int missingNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; ++i){
            map.put(nums[i], nums[i]);
        }
        
        for(int i = 0; i <= nums.length; ++i){
            if(!map.containsKey(i))
                return i;
        }
        
        return -1;
    }
}