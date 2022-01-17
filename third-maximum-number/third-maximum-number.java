class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <3)
            return nums[nums.length -1];
        
        
        
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int uniqueCount = 0;
        
        for(int i = nums.length-1; i >= 0; i--){
            if(!map.containsKey(nums[i])){
                uniqueCount++;
                if(uniqueCount == 3){
                    return nums[i];
                } else{
                    map.put(nums[i], nums[i]);
                }
            }
        }
        
        return nums[nums.length-1];
    }
}