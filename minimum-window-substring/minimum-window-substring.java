class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        
        for(char c : t.toCharArray()){
            map[c]++;
        }
        
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, count = t.length();
        
        while(end < s.length()){
            final char c1 = s.charAt(end);
            if(map[c1] > 0)
                count--;
            map[c1]--;
            end++;
            
            while(count == 0){
                if(minLen > end - start){
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                if(map[c2] > 0){
                    count++;
                }
                start++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}