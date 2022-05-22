class Solution {
    public int minSteps(String s, String t) {
        int[] sMap = new int[26];
        int[] tMap = new int[26];
        
        
        fill(s, sMap);
        fill(t, tMap);
        int sSteps = 0;
        int tSteps = 0;
        for(int i = 0; i < 26; ++i){
            if(sMap[i] > tMap[i])
                sSteps += sMap[i] - tMap[i];
            
            if(tMap[i] > sMap[i])
                tSteps += tMap[i] - sMap[i];
        }
        
        return Math.min(sSteps, tSteps);
    }
    
    public void fill(String s, int[] map){
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map[c - 'a']++;
        }
    }
}