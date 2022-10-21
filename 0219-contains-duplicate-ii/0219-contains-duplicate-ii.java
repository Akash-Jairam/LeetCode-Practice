class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; ++i){
            if(map.containsKey(nums[i])){
                for(int idx : map.get(nums[i])){
                    if(Math.abs(i - idx) <= k) return true;
                }
            }
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        return false;
    }
}