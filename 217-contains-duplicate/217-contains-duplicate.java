class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return false;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1 );
                if(map.get(num) >= 2)
                    return true;
            }
            map.put(num, 1);
        }
        
        return false;
    }
}