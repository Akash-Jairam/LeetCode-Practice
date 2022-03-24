class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        if(nums.length == 0 || nums == null)
            return 0;
        for(int num : nums){
            set.add(num);
        }
        
        int count = 1; 
        int max = 1;
        while(!set.isEmpty()){
            Iterator<Integer> it = set.iterator();
            int num = it.next();
            int num1 = num;
            set.remove(num);
            while(set.contains(num - 1)){
                ++count;
                num = num - 1;
                set.remove(num);
            }
            while(set.contains(num1  + 1)){
                ++count;
                num1 = num1 + 1;
                set.remove(num1);
            }
            max = Math.max(max, count);
            count = 1;
        }
        
        return Math.max(max, count);
    }
}