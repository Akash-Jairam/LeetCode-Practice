class Solution {
    public int minSteps(String s, String t) {
        int[] sMap = new int[26];
        int[] tMap = new int[26];
        
        map(s, sMap);
        map(t, tMap);
        int count = 0;
        for(int i = 0; i < 26; ++i){
            if(tMap[i] != sMap[i]){
                count += Math.abs(tMap[i] - sMap[i]);
            }
        }
        
        return count/2;
    }
    
    public void map(String s, int[] map){
        for(int i = 0; i < s.length(); ++i){
            map[s.charAt(i) - 'a']++;
        }
    }
}