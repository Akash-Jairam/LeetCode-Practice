class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int len = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){                
                start = Math.max(start,map.get(s.charAt(i)) + 1);
                
            }    
            map.put(s.charAt(i), i);
            len = Math.max(len, i - start +1 );
        }
        
        return len;
    }
}