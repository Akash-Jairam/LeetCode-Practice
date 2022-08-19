class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        
        for(int num : nums)
            left.put(num, left.getOrDefault(num, 0) + 1);
        
        for(int num : nums){
            if(left.get(num) <= 0) continue;
            
            left.put(num, left.get(num) - 1);
            
            if(right.containsKey(num-1) && right.get(num-1) > 0){
                right.put(num - 1, right.get(num - 1) - 1);
                right.put(num, right.getOrDefault(num, 0) + 1);
                continue;
            }
            
            if((left.containsKey(num + 1) && left.get(num + 1) > 0) && 
                left.containsKey(num + 2) && left.get(num + 2) > 0
              ){
                left.put(num + 1, left.get(num + 1) - 1);
                left.put(num + 2, left.get(num + 2) - 1);
                right.put(num + 2, right.getOrDefault(num + 2, 0) + 1);
                continue;
            }
            
            return false;
        }
        return true;
    }
}