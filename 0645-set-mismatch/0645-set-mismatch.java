class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = nums.length;
        int[] res = new int[2];
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int i = 1; i <= max; ++i){
            if(!map.containsKey(i)) res[1] = i;
            else if(map.get(i) == 2) res[0] = i;
        }
        
        return res;
        
    }
}