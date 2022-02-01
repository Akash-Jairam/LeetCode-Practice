class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0, max = 0;
        int left = 0;
        if(s.length() == 0 )
            return len;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left){
                max = Math.max(max, len);
                left = map.get(s.charAt(i)) +1;
                len = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            } else{
                map.put(s.charAt(i), i);
                len++;
            }
        }
        
        
        
        return Math.max(max, len);
    }
}