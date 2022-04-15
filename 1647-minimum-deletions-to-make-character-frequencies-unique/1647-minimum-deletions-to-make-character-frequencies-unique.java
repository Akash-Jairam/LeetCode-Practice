class Solution {
    public int minDeletions(String s) {
        if(s.isEmpty() || s.isBlank() || s.length() <= 1)
            return 0;
        
        TreeMap<Character, Integer> map = new TreeMap<>();
        int minDeletions = 0;
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1 );
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(Character key : map.keySet()){
            int count = map.get(key);
            while(set.contains(count) && count > 0){
                --count;
                ++minDeletions;
            }
            if(count > 0)
                set.add(count);
        }
        
        return minDeletions;
    }
}