class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        Integer runningSum = 0;
        for(int i = 0; i < nums.length; ++i){
            runningSum += nums[i];
            if(k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if(prev != null){
                if(i - prev > 1) return true;
            } else{
                map.put(runningSum, i);
            }
        }
        
        return false;
    }
}