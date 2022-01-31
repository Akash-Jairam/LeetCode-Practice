class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; ++i){
            map.put(i, nums[i]);
        }
        
        for(int i = 0; i < nums.length; ++i){
            int count = i+1;
            while(count < nums.length-1 && nums[i] + nums[count] != target){
                count++;
            }
            if(nums[i] + nums[count] == target){
                result[0] = i;
                result[1] = count;
                return result;
            }
        }
        return result;
    }
    
}