class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(map.containsKey(num))
                return true;
            
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return false;
    }
}