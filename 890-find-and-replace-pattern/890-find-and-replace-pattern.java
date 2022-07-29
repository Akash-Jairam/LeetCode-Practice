class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        
        for(String word : words){
            if(match(word, pattern)){
                res.add(word);
            }
        }
        
        return res;
    }
    
    public boolean match(String word, String pattern){
        HashMap<Character, Character> wMap = new HashMap<>();
        HashMap<Character, Character> pMap = new HashMap<>();
        
        for(int i = 0; i < word.length(); ++i){
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if(!wMap.containsKey(w)) wMap.put(w,p);
            if(!pMap.containsKey(p)) pMap.put(p,w);
            
            if(wMap.get(w) != p || pMap.get(p) != w){
                return false;
            }
        }
        
        return true;
    }
}