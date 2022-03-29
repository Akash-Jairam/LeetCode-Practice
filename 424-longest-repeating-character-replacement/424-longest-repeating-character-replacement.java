class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int n = s.length();
        int max_count = 0;
        int max_length = 0;
        int[] map = new int[26];
        int window_start = 0;
        
        for(int window_end = window_start; window_end < n; ++window_end){
            map[s.charAt(window_end) - 'A']++;
            int curr_length = map[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, curr_length);
            
            while(window_end - window_start - max_count +1 > k){
                map[s.charAt(window_start) - 'A']--;
                ++window_start;
            }
            
            max_length = Math.max(max_length, window_end - window_start + 1);
        }
        
        return max_length;
    }
}